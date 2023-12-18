package main.java.com.bigcousin.chatroom.client.core;

import java.io.*;
import java.net.Socket;
import java.util.List;

import main.java.com.bigcousin.chatroom.common.info.room.RoomInfo;
import main.java.com.bigcousin.chatroom.common.info.user.UserInfo;
import main.java.com.bigcousin.chatroom.common.message.*;
import main.java.com.bigcousin.chatroom.common.request.ClientRequest;
import main.java.com.bigcousin.chatroom.common.request.ClientRequestType;

// ... 导入语句 ...

public class ChatClient {
    private List<RoomInfo> roomInfos;
    private RoomInfo roomInfo;
    private UserInfo userInfo;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Socket socket;
    private boolean isLogged;
    private String serverAddress;
    private int port;

    public ChatClient(String nickname,String serverAddress, int port) {
        isLogged=false;
        this.serverAddress=serverAddress;
        this.port=port;
        this.userInfo = new UserInfo(nickname);
    }
    public ChatClient(String serverAddress, int port){
        this.serverAddress=serverAddress;
        this.port=port;
        isLogged=false;
    }
    public void login(String nickName) {
        if (isLogged) {
            return;
        }
        connect(serverAddress, port);
        startMessageReceiver();
        try {
            out.writeObject(new LoginMessage(nickName));
        } catch (IOException e) {
            System.err.println("Login failed: " + e.getMessage());
            return;
        }
        isLogged = true;
    }
    public void requestRoomInfosFromServer() {
        ClientRequest clientRequest =new ClientRequest(userInfo, ClientRequestType.GET_LIST_ROOM);
        try {
            out.writeObject(clientRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void selectRoom(String roomName) {
        // 创建房间选择消息
        RoomSelectionMessage roomSelectionMessage = new RoomSelectionMessage(roomName, userInfo);
        System.out.println("准备发送进入房间的请求");
        try {
            // 发送房间选择消息
            out.writeObject(roomSelectionMessage);
            System.out.println("发送进入房间的请求");
        } catch (IOException e) {
            System.err.println("Error sending room selection message: " + e.getMessage());
        }
    }
    public void refreshRoomList(){
        requestRoomInfosFromServer();
        //重新渲染选择房间页面
    }

    public void logout() {
        if (!isLogged) {
            return; // 用户未登录，无需登出
        }
        try {
            // 如果需要发送登出消息给服务器
            out.writeObject(new LogoutMessage(userInfo));
            // 关闭输入输出流和套接字
            closeConnection();
            // 更新状态
            isLogged = false;
            userInfo = null; // 或根据需要重置 userInfo
            System.out.println("Logged out successfully.");
        } catch (IOException e) {
            System.err.println("Error during logout: " + e.getMessage());
        }
    }
    public void sendMessage(Message message) {
        if(message==null){
            System.out.println("消息为空");
        }
        else{
            if(message instanceof ChatMessage){
                try {
                    out.writeObject(message);
                    System.out.println("发送消息:"+((ChatMessage) message).getMessage());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
    private void connect(String serverAddress, int port) {
        try {
            socket = new Socket(serverAddress, port);
            out = new ObjectOutputStream(socket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }
    private void startMessageReceiver() {
        new ObjectReceiver(in).start();
    }

    // ObjectReceiver 类
    private class ObjectReceiver extends Thread {
        private ObjectInputStream objectInputStream;

        public ObjectReceiver(ObjectInputStream objectInputStream) {
            this.objectInputStream = objectInputStream;
        }

        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    Object object = objectInputStream.readObject();
                    handleReceivedObject(object);
                }
            } catch (EOFException e) {
                System.err.println("Server connection closed: " + e.getMessage());
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Receiving error: " + e.getMessage());
            } finally {
                closeResources();
            }
        }

        private void closeResources() {
            // 安全关闭资源
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
    private void handleReceivedObject(Object obj) {
        if (obj==null)return;
        System.out.println("从服务器获取数据");
        if (obj instanceof ChatMessage) {
            handleChatMessage((ChatMessage) obj);
        } else if (obj instanceof UserInfo) {
            userInfo = (UserInfo) obj;
            System.out.println("获取用户序号:" + userInfo.getId());
        } else if (obj instanceof List<?>) {
            // 检查列表中的元素类型
            List<?> list = (List<?>) obj;
            System.out.println("转换数据类型为列表");;
            if (!list.isEmpty() && list.get(0) instanceof RoomInfo) {
                // 安全地处理作为 RoomInfo 的列表
                handleRoomInfoList((List<RoomInfo>) list);
            }
        } else if (obj instanceof RoomInfo) {
            System.out.println("获取房间数据");
            roomInfo=(RoomInfo) obj;
            userInfo.setRoomInfo(roomInfo);
            System.out.println("已进入房间："+userInfo.getRoomInfo().getName());
            //获取所进入房价信息
        }
        // 可以添加后续的处理逻辑
    }
    private void handleChatMessage(ChatMessage chatMessage){
        System.out.println(chatMessage.toString());
    }
    private void handleRoomInfoList(List<RoomInfo> roomInfoList) {
        // 在这里处理房间信息列表
        for (RoomInfo roomInfo : roomInfoList) {
            // 例如，打印房间信息或更新用户界面
            System.out.println("Room: " + roomInfo.getName());
        }
    }
    private void closeConnection() throws IOException {
        if (in != null) {
            in.close();
            in = null;
        }
        if (out != null) {
            out.close();
            out = null;
        }
        if (socket != null && !socket.isClosed()) {
            socket.close();
            socket = null;
        }
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public List<RoomInfo> getRoomInfos() {
        return roomInfos;
    }

    public RoomInfo getRoomInfo() {
        return roomInfo;
    }
}