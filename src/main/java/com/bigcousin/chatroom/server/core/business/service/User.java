package main.java.com.bigcousin.chatroom.server.core.business.service;

import main.java.com.bigcousin.chatroom.transdata.user.UserInfo;
import main.java.com.bigcousin.chatroom.server.ui.LogOutputWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class User extends Thread {
    private UserInfo userInfo;
    private Socket socket;
    private LogOutputWindow logOutputWindow;

    public User(UserInfo userInfo, Socket socket, LogOutputWindow logOutputWindow) {
        this.userInfo = userInfo;
        this.socket = socket;
        this.logOutputWindow = logOutputWindow;
    }

    public void run() {
        try {
            // 获取输入流和输出流
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // 在这里添加处理逻辑
            writer.println("Welcome, " + userInfo.getNickname() + "!");

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
