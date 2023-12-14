package main.java.com.bigcousin.chatroom.server.service;

import main.java.com.bigcousin.chatroom.common.info.room.RoomInfo;
import main.java.com.bigcousin.chatroom.common.info.room.RoomInfoList;
import main.java.com.bigcousin.chatroom.common.info.user.UserInfo;
import main.java.com.bigcousin.chatroom.common.message.*;
import main.java.com.bigcousin.chatroom.server.service.room.Room;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ChatServer {
    private final int PORT = 12345;
    private ServerSocket serverSocket;
    private InetAddress serverAddress;
    private RoomInfoList roomInfoList;
    private ArrayList<Room> rooms;
    private ArrayList<ClientHandler> clientHandlers;
    private ArrayList<UserInfo> userInfos;

    public ChatServer() {
        clientHandlers=new ArrayList<>();
        roomInfoList=new RoomInfoList();
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
        creatRoom("BigCousin'Chatroom");
        ServerEntrance serverEntrance=new ServerEntrance();
        serverEntrance.start();
    }
    private void creatRoom(String roomName){
        Room room=new Room(new RoomInfo(roomName,10,rooms.size()));
        rooms.add(room);
        roomInfoList.add(room.getRoomInfo());
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
    private void borderCast(ChatMessage chatMessage){

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

                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
        }
        private void handleMessage(Object message){
            if(message instanceof ChatMessage){
                ChatMessage chatMessage=(ChatMessage) message;
                borderCast(chatMessage);
            } else if (message instanceof LogoutMessage) {

            } else if (message instanceof LoginMessage) {
                //默认已登录，暂时不处理
            } else if (message instanceof RoomSelectionMessage) {
                RoomSelectionMessage roomSelectionMessage=(RoomSelectionMessage) message;

            }
        }
        public void sendMessage(){

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
        public UserInfo getUserInfo() {
            return userInfo;
        }

        // 其他必要的方法，比如 broadcastMessage
    }
}