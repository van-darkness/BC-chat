package server.service;

import java.io.*;
import java.net.*;
import java.util.*;

import common.*;

public class ClientHandler extends Thread {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            // ...
            Object obj;
            while ((obj = in.readObject()) != null) {
                if (obj instanceof LoginMessage) {
                    // 处理登录消息
                    LoginMessage loginMsg = (LoginMessage) obj;
                    // ...
                } else if (obj instanceof ChatMessage) {
                    // 处理聊天消息
                    ChatMessage chatMsg = (ChatMessage) obj;
                    // ...
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            // 异常处理
        } finally {
            // 清理资源
        }
    }
}