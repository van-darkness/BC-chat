package server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Room implements Runnable {
    private String name;
    private List<ClientHandler> clients;

    public Room(String name) {
        this.name = name;
        this.clients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addClient(ClientHandler client) {
        clients.add(client);
    }

    @Override
    public void run() {
        // 在这里处理房间的消息传递逻辑
        // 可以添加更多的逻辑，例如处理客户端消息、向所有客户端广播消息等
        while (true) {
            // 这里可以添加处理消息的逻辑
        }
    }

    // 向房间内的所有客户端广播消息
    public void broadcastMessage(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    // 移除房间内的客户端
    public void removeClient(ClientHandler client) {
        clients.remove(client);
    }
}
