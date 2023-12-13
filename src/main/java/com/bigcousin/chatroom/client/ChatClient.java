package main.java.com.bigcousin.chatroom.client;

import java.io.*;
import java.net.Socket;
import javax.swing.JTextArea;

import main.java.com.bigcousin.chatroom.common.message.ChatMessage;
import main.java.com.bigcousin.chatroom.common.message.LoginMessage;

public class ChatClient {
    private String nickname;
    private JTextArea chatArea;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Socket socket;

    public ChatClient(String nickname, JTextArea chatArea) {
        this.nickname = nickname;
        this.chatArea = chatArea;
    }

    public void connect(String serverAddress, int port) {
        try {
            // 建立连接
            socket = new Socket(serverAddress, port);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            // 发送登录消息
            out.writeObject(new LoginMessage(nickname));

            // 接收消息的线程
            Thread receiver = new Thread(() -> {
                try {
                    while (true) {
                        Object obj = in.readObject();
                        if (obj instanceof ChatMessage) {
                            ChatMessage msg = (ChatMessage) obj;
                            chatArea.append(msg.getMessage() + "\n");
                        }
                    }
                } catch (Exception e) {
                    chatArea.append("Disconnected from server.\n");
                }
            });
            receiver.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeObject(new ChatMessage(nickname + ": " + message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 其他方法
}
