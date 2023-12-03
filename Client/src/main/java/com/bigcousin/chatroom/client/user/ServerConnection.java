package main.java.com.bigcousin.chatroom.client.user;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerConnection {
    private Socket socket;
    private Scanner serverInput;
    private PrintWriter serverOutput;

    public ServerConnection(String serverAddress, int port) {
        try {
            // 建立与服务器的连接
            socket = new Socket(serverAddress, port);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            serverInput = new Scanner(inputStream);
            serverOutput = new PrintWriter(outputStream, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isConnected() {
        return socket != null && socket.isConnected();
    }

    // 发送数据到服务器
    public void sendToServer(String data) {
        // 使用PrintWriter将数据写入服务器
        serverOutput.println(data);
    }

    // 从服务器接收数据
    public String receiveFromServer() {
        // 使用Scanner从服务器输入流读取数据
        return serverInput.nextLine();
    }

    // 关闭连接
    public void closeConnection() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
