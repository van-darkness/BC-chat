package handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import space.Room;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private Room room;
    private PrintWriter writer;
    private Scanner reader;

    public ClientHandler(Socket clientSocket, Room room) {
        this.clientSocket = clientSocket;
        this.room = room;

        try {
            this.writer = new PrintWriter(clientSocket.getOutputStream(), true);
            this.reader = new Scanner(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 发送消息给客户端
    public void sendMessage(String message) {
        writer.println(message);
    }

    @Override
    public void run() {
        try {
            // 在这里处理客户端的消息逻辑
            while (true) {
                if (reader.hasNextLine()) {
                    String message = reader.nextLine();
                    // 在这里处理客户端发送的消息
                    // 可以根据实际需求进行处理，例如广播给房间内的其他客户端
                    room.broadcastMessage(message);
                }
            }
        } catch (Exception e) {
            // 客户端断开连接时的处理逻辑
            room.removeClient(this);
            try {
                clientSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
