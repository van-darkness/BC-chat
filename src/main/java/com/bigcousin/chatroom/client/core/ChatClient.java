package main.java.com.bigcousin.chatroom.client.core;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JTextArea;

import main.java.com.bigcousin.chatroom.common.info.user.UserInfo;
import main.java.com.bigcousin.chatroom.common.message.ChatMessage;
import main.java.com.bigcousin.chatroom.common.message.LoginMessage;
import main.java.com.bigcousin.chatroom.common.message.Message;
import main.java.com.bigcousin.chatroom.common.message.RoomSelectionMessage;

// ... 导入语句 ...

public class ChatClient {
    private UserInfo userInfo;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Socket socket;

    public ChatClient(String nickname) {
        this.userInfo = new UserInfo(nickname);
    }

    public void connect(String serverAddress, int port) {
        try {
            socket = new Socket(serverAddress, port);
            out = new ObjectOutputStream(socket.getOutputStream());
            out.flush();  // 确保首先发送流的头部信息
            in = new ObjectInputStream(socket.getInputStream());


            // 发送登录消息
            out.writeObject(new LoginMessage(userInfo.getNickname()));

            // 开始接收服务器消息的线程
            startMessageReceiver();

            // 处理用户输入
            //handleUserInput();
        } catch (IOException e) {
            e.printStackTrace();
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

    private void handleUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You can start typing your messages:");

        while (true) {
            String message = scanner.nextLine();
            ChatMessage chatMessage=new ChatMessage(message,userInfo);
            //GUI界面中要修改退出机制
            if ("quit".equalsIgnoreCase(chatMessage.getMessage())) {
                break; // 或者执行其他退出逻辑
            }
            sendMessage(chatMessage);
        }
    }

    private void handleReceivedObject(Object obj) {
        if (obj instanceof ChatMessage) {
            ChatMessage msg = (ChatMessage) obj;
            System.out.println(msg.getMessage());
        } else if (obj instanceof UserInfo) {
            userInfo=(UserInfo) obj;
            //System.out.println("获取用户序号:"+userInfo.getId());
        }
        // 可以根据需要处理更多消息类型
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

    // ... 其他方法 ...
}
