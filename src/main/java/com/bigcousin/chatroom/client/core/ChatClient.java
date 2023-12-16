package main.java.com.bigcousin.chatroom.client.core;

import java.io.*;
import java.net.Socket;
import java.util.List;

import main.java.com.bigcousin.chatroom.common.info.room.RoomInfo;
import main.java.com.bigcousin.chatroom.common.info.user.UserInfo;
import main.java.com.bigcousin.chatroom.common.message.*;
import main.java.com.bigcousin.chatroom.common.request.Request;
import main.java.com.bigcousin.chatroom.common.request.RequestType;

// ... 导入语句 ...

public class ChatClient {
    private List<RoomInfo> roomInfos;
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
    public void login(String nickName){
        if(isLogged)return;
        //从登录窗口获取昵称，
        connect(serverAddress,port);
        // 开始接收服务器消息的线程
        startMessageReceiver();
        // 发送登录消息
        try {
            out.writeObject(new LoginMessage(nickName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        isLogged=true;
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
            out.flush();  // 确保首先发送流的头部信息
            in = new ObjectInputStream(socket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectRoom(String name) {

    }

    public void requestRoomInfosFromServer() {
        Request request=new Request(userInfo, RequestType.GET_LIST_ROOM);
        try {
            out.writeObject(request);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    class MessageReceiver extends Thread{
        @Override
        public void run() {
            super.run();
            while(true){
                Object obj;
                try {
                    obj = in.readObject();
                    handleReceivedObject(obj);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    private void startMessageReceiver() {
        MessageReceiver messageReceiver=new MessageReceiver();
        messageReceiver.start();
    }
    private void handleReceivedObject(Object obj) {
        if (obj instanceof ChatMessage) {
            ChatMessage msg = (ChatMessage) obj;
            System.out.println(msg.getMessage());
        } else if (obj instanceof UserInfo) {
            userInfo = (UserInfo) obj;
            System.out.println("获取用户序号:" + userInfo.getId());
        } else if (obj instanceof List) {
            // 检查列表中的元素类型
            List<?> list = (List<?>) obj;
            if (!list.isEmpty() && list.get(0) instanceof RoomInfo) {
                // 安全地处理作为 RoomInfo 的列表
                handleRoomInfoList((List<RoomInfo>) list);
            }
        }
        // 可以添加后续的处理逻辑
    }
    private void handleRoomInfoList(List<RoomInfo> roomInfoList) {
        roomInfos=roomInfoList;
        for (RoomInfo roomInfo : roomInfoList) {
            // 打印房间信息，或进行其他处理
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
}