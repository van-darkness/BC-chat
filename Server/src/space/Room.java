package space;

import java.util.*;

import handlers.ClientHandler;

public class Room implements Runnable {
    private String name;
    private List<ClientHandler> clients;
    private boolean running;

    public Room(String name) {
        this.name = name;
        this.clients = new ArrayList<>();
        this.running = false;
    }

    public String getName() {
        return name;
    }

    public void addClient(ClientHandler client) {
        clients.add(client);
    }

    @Override
    public void run() {
        // TODO:整体逻辑：房间类有消息接受的循环，然后接受每个用户线程的消息输入，然后把消息发送欸同房间的每一位用户
        // 在这里处理房间的消息传递逻辑
        // 可以添加更多的逻辑，例如处理客户端消息、向所有客户端广播消息等
        while (true) {
            // 这里可以添加处理消息的逻辑
        }
    }

    // TODO: 考虑到后期的用户界面显示，系统/房间消息的显示区域是和群聊消息不同的
    // TODO:系统/房间消息用单独的线程操作
    // 向房间内的所有客户端广播消息
    public void broadcastMessage(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    // 接收某位用户的信息并向同房间里的人发送信息
    private void clientMessage(String message, ClientAPP client) {

    }

    // 移除房间内的客户端
    public void removeClient(ClientHandler client) {
        clients.remove(client);
    }

    public synchronized void start() {
        running = true;
    }

    public synchronized void stop() {
        running = false;
    }

    public synchronized boolean isRunning() {
        return running;
    }
}
