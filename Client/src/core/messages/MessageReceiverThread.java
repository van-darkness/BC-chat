package core.messages;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MessageReceiverThread extends Thread {
    private Socket serverSocket;
    private Scanner reader;

    public MessageReceiverThread(Socket serverSocket) {
        this.serverSocket = serverSocket;
        try {
            InputStream inputStream = serverSocket.getInputStream();
            reader = new Scanner(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message;
        while (reader.hasNextLine()) {
            message = reader.nextLine();
            // 处理接收到的消息，可以更新用户界面等操作
            System.out.println("Received message: " + message);
            // TODO:将信息显示在用户UI界面上
        }
    }
}
