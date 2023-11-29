package server;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import server.entrance.ServerEntrance;
import server.handlers.ClientHandler;
import server.space.Room;

public class Server {
    private ServerSocket serverSocket;
    private List<Room> rooms;
    private InetAddress computer;

    public Server(int port) {
        try {
            computer = InetAddress.getLocalHost();
            System.out.println("服务器地址：" + computer + "端口：" + port);
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // ServerEntrance类实现用户进入并登录，通过多个入口线程并使用线程池技术来实现大量用户的接入
        // 暂时使用单个入口进行用户接入
        ServerEntrance entrance = new ServerEntrance(port);
        Thread entrance_run = new Thread(entrance);
        entrance_run.start();
    }

    public void start() {

        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                Room room = getOrCreateRoom("General");
                ClientHandler clientHandler = new ClientHandler(clientSocket, room);

                // 将客户端加入房间
                room.addClient(clientHandler);

                // 如果房间的线程还没有启动，启动它
                if (!room.isRunning()) {
                    new Thread(room).start();
                }
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
        // 如果房间不存在，创建新房间但不启动线程
        Room newRoom = new Room(roomName);
        rooms.add(newRoom);
        return newRoom;
    }

    public static void main(String[] args) {
        int port = 8888;
        Server server = new Server(port);
        // server.start();
    }
}