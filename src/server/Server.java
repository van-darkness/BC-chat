package src.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private ServerSocket serverSocket;
    private List<Room> rooms;

    public Server(int port) {
        rooms = new ArrayList<>();
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is running on port " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        while (true) {
            try {
                // 等待客户端连接
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                // 获取或创建房间
                Room room = getOrCreateRoom("General");
                ClientHandler clientHandler=new ClientHandler(clientSocket, room);
                // 将客户端加入房间
                room.addClient(clientHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Room getOrCreateRoom(String roomName) {
        for (Room room : rooms) {
            if (room.getName().equals(roomName)) {
                return room;
            }
        }
        // 如果房间不存在，创建新房间并启动线程
        Room newRoom = new Room(roomName);
        rooms.add(newRoom);
        new Thread(newRoom).start();
        return newRoom;
    }

    public static void main(String[] args) {
        int port = 8888; // 服务器端口
        Server server = new Server(port);
        server.start();
    }
}
