package main.java.com.bigcousin.chatroom.server.service;

import main.java.com.bigcousin.chatroom.common.info.room.RoomInfo;
import main.java.com.bigcousin.chatroom.common.info.user.UserInfo;
import main.java.com.bigcousin.chatroom.common.message.*;
import main.java.com.bigcousin.chatroom.common.request.ClientRequest;
import main.java.com.bigcousin.chatroom.server.exception.NullMessageException;
import main.java.com.bigcousin.chatroom.server.exception.RoomCreatException;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private final int PORT = 8888;
    private ServerSocket serverSocket;
    private InetAddress serverAddress;
    private ArrayList<Room> rooms;
    private ArrayList<ClientHandler> clientHandlers;
    private ArrayList<UserInfo> userInfos;

    public ChatServer() {
        clientHandlers=new ArrayList<>();
        userInfos=new ArrayList<>();
        rooms=new ArrayList<>();
        try {
            serverAddress=InetAddress.getLocalHost();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        try {
            serverSocket=new ServerSocket(PORT);
            System.out.println("服务器创建，地址为："+serverAddress.getHostAddress()+",端口为："+PORT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
                creatRoom("BigCousin'Chatroom");
        } catch (RoomCreatException e) {
            throw new RuntimeException(e);
        }
        ServerEntrance serverEntrance=new ServerEntrance();
        serverEntrance.start();
    }
    private void creatRoom(String roomName) throws RoomCreatException {
        for(int i=0;i<rooms.size();i++){
            if(rooms.get(i).getRoomInfo().getName().equals(roomName)){
                throw new RoomCreatException(roomName);
            }

        }
        Room room=new Room(new RoomInfo(roomName,10,rooms.size()));
        rooms.add(room);
        System.out.println("创建新房间:"+room.getRoomInfo().toString());
        // 获取更新后的房间列表
        List<RoomInfo> roomInfos = getRoomInfos();
        // 广播新的房间列表
        //broadcastObject(roomInfos);
    }
    public void addClientHandler(ClientHandler handler) {
        synchronized (clientHandlers) {
            clientHandlers.add(handler);
        }
    }

    public void removeClientHandler(ClientHandler handler) {
        synchronized (clientHandlers) {
            clientHandlers.remove(handler);
        }
    }
    public void removeClientHandler(ClientHandler handler,RoomInfo roomInfo){
        //同时将用户从房间和大厅中移除
    }
    public void addUserToRoom(UserInfo userInfo,int i){
        //i事要加入的房间在房间列表中的序号

        userInfo.setRoomInfo(rooms.get(i).getRoomInfo());
        rooms.get(i).addUser(userInfo);
        System.out.println("已将用户添加至房间:"+rooms.get(i).getRoomInfo().getName());
    }
    public void addUserToRoom(UserInfo userInfo,String roomName){
        for(int i=0;i<rooms.size();i++){
            if(roomName==rooms.get(i).getRoomInfo().getName()){
                rooms.get(i).addUser(userInfo);
                userInfo.setRoomInfo(rooms.get(i).getRoomInfo());
            }
        }
    }
    public void broadcastMessage(Message message) {
        synchronized (clientHandlers) {
            for (ClientHandler handler : clientHandlers) {
                handler.sendMessage(message);
            }
        }
    }

    private void borderCast(SystemMessage systemMessage){}

    class ServerEntrance extends Thread{
        @Override
        public void run() {
            super.run();
            while(true){
                Socket socket;
                try {
                    socket=serverSocket.accept();
                    ClientHandler clientHandler=new ClientHandler(socket);
                    clientHandlers.add(clientHandler);
                    clientHandler.start();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
    class ClientHandler extends Thread {
        private UserInfo userInfo;
        private Socket socket;
        private ObjectInputStream objectInputStream;
        private ObjectOutputStream objectOutputStream;

        public ClientHandler(Socket socket, UserInfo userInfo) {
            this.socket = socket;
            this.userInfo = userInfo;
            try {
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.flush();
                objectInputStream = new ObjectInputStream(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public ClientHandler(Socket socket){
            this.socket=socket;
            try {
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.flush();
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                Object object=objectInputStream.readObject();
                if(object!=null){
                    if(object instanceof LoginMessage){
                        System.out.println("获取登录数据");
                        //处理登录消息
                        LoginMessage loginMessage=(LoginMessage) object;
                        System.out.println(loginMessage.getNickname());
                        UserInfo newUserInfo=new UserInfo(loginMessage.getNickname(),userInfos.size());
                        this.userInfo=newUserInfo;
                        userInfos.add(userInfo);
                        objectOutputStream.writeObject(userInfo);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        public void run() {
            try {
                if (objectInputStream == null) {
                    throw new IOException("Input stream is null");
                }

                while (true) {
                    Object message = objectInputStream.readObject();
                    // ... 处理接收到的消息 ...
                    handleMessage(message);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NullMessageException e) {
                throw new RuntimeException(e);
            } finally {
                closeConnection();
            }
        }
        // 方法用于发送房间信息列表
        private void sendRoomList() {
            try {
                List<RoomInfo> roomInfos = ChatServer.this.getRoomInfos(); // 获取房间信息列表
                objectOutputStream.writeObject(roomInfos); // 发送房间信息列表
                System.out.println("已发送房间列表数据");
                for (int i=0;i<roomInfos.size();i++){
                 System.out.println(roomInfos.get(i));
                }
                objectOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace(); // 处理异常，例如记录日志
            }
        }
        private void handleMessage(Object object) throws NullMessageException {
            if(object!=null){
                if(object instanceof ChatMessage){
                    ChatMessage chatMessage=(ChatMessage) object;
                    broadcastMessage((Message) object);
                } else if (object instanceof LogoutMessage) {

                    // 处理用户登出
                    LogoutMessage logoutMessage = (LogoutMessage) object;
                    // ... 处理登出逻辑 ...
                    closeConnection();
                    removeClientHandler(this);
                } else if (object instanceof LoginMessage) {
                    //默认已登录，暂时不处理
                } else if (object instanceof RoomSelectionMessage) {

                    RoomSelectionMessage roomSelectionMessage=(RoomSelectionMessage) object;
                    System.out.println("获取进入房间请求；"+"->"+roomSelectionMessage.getRoomName());
                    handleRoomSelectionMessage(roomSelectionMessage);
                } else if (object instanceof ClientRequest) {
                    ClientRequest clientRequest = (ClientRequest) object;
                    switch (clientRequest.getRequestTypel()) {
                        case GET_LIST_ROOM:
                            System.out.println("准备发送房间列表");
                            sendRoomList();
                            break;
                        case GET_LIST_USER:
                            sendUserList(userInfo);
                            break;
                        // 其他请求类型...
                    }
                }
            }else{
                throw new NullMessageException(userInfo);
            }

        }
        private void sendUserList(UserInfo user) {
            try {
                List<UserInfo> userList = getUsersInSameRoom(user); // 获取同一房间的用户信息列表
                objectOutputStream.writeObject(userList); // 发送用户信息列表
                objectOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace(); // 处理异常
            }
        }

        // 获取与指定用户处于同一房间的所有用户的列表
        private List<UserInfo> getUsersInSameRoom(UserInfo user) {
            Room userRoom = findUserRoom(user);
            return userRoom != null ? new ArrayList<>(userRoom.getUserInfos()) : new ArrayList<>();
        }
        private void handleRoomSelectionMessage(RoomSelectionMessage message){
            if(!message.isSwitch()){
                //初次加入房间
                String roomname=message.getRoomName();
                for(int i=0;i<rooms.size();i++){
                    if(roomname.equals(rooms.get(i).getRoomInfo().getName())){
                        addUserToRoom(userInfo,i);
                        //向客户端发送房间信息
                        sendObject((Object) rooms.get(i).getRoomInfo());
                        return;
                    }
                }
                try {
                    creatRoom(roomname);
                    addUserToRoom(message.getUserInfo(),roomname);
                } catch (RoomCreatException e) {
                    throw new RuntimeException(e);
                }
            }else {
                //切换房间
                System.out.println("开始处理请求");
                Room currentRoom=findUserRoom(userInfo);
                if(currentRoom!=null){
                    currentRoom.removeUser(userInfo);
                }
                String roomname=message.getRoomName();
                for(int i=0;i<rooms.size();i++){
                    if(roomname.equals(rooms.get(i).getRoomInfo().getName())){
                        addUserToRoom(userInfo,i);

                        return;
                    }
                }
                try {
                    creatRoom(roomname);
                    addUserToRoom(message.getUserInfo(),roomname);
                } catch (RoomCreatException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        private Room findUserRoom(UserInfo user) {
            for (Room room : rooms) {
                if (room.getUserInfos().contains(user)) {
                    return room;
                }
            }
            return null;
        }
        public void sendMessage(Message message) {
            if (message == null) {
                return;
            }
            try {
                objectOutputStream.writeObject(message);
                objectOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private void closeConnection() {
            try {
                if (objectInputStream != null) objectInputStream.close();
                if (objectOutputStream != null) objectOutputStream.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void sendObject(Object obj) {
            try {
                objectOutputStream.writeObject(obj);
                objectOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace(); // 或记录日志
            }
        }
        // 其他必要的方法
    }
    public void broadcastObject(Object obj) {
        synchronized (clientHandlers) {
            for (ClientHandler handler : clientHandlers) {
                handler.sendObject(obj);
            }
        }
    }
    private List<RoomInfo> getRoomInfos() {
        List<RoomInfo> roomInfos = new ArrayList<>();
        for (Room room : rooms) {
            roomInfos.add(room.getRoomInfo());
        }
        return roomInfos;
    }

}