package main.java.com.bigcousin.chatroom.sever.authentication;

import java.net.Socket;

import main.java.com.bigcousin.chatroom.sever.message.MessageSource;
import main.java.com.bigcousin.chatroom.sever.message.MessageType;
import main.java.com.bigcousin.chatroom.sever.message.SystemMessage;
import main.java.com.bigcousin.chatroom.sever.ui.LogOutputWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UserHandler extends Thread {
    private User user;
    private Socket socket;
    private LogOutputWindow logOutputWindow;

    public UserHandler(User user, Socket socket, LogOutputWindow logOutputWindow) {
        this.user = user;
        this.socket = socket;
        this.logOutputWindow = logOutputWindow;
    }

    public void run() {
        try {
            // 获取输入流和输出流
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // 在这里添加处理逻辑
            writer.println("Welcome, " + user.getNickname() + "!");

            String userInput;
            while ((userInput = reader.readLine()) != null) {
                // TODO:处理用户输入

                // 在这里添加其他处理逻辑
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭资源
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
