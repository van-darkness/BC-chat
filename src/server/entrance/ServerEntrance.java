package server.entrance;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import server.handlers.ClientHandler;
import server.space.Room;

public class ServerEntrance implements Runnable {
    ServerSocket serverSocket;
    Socket clientSocket;
    PrintWriter writer;
    Scanner reader;

    public ServerEntrance(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());
                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();
                writer = new PrintWriter(outputStream, true);
                reader = new Scanner(inputStream);
                boolean isMatched;
                for (i = 0; i < 10; i++) {
                    isMatched = receiveAccountInfo(reader);
                    if (isMatched) {
                        writer.println("账号信息正确，请选择房间");
                    } else {
                        writer.println("账号或密码有误，请重新输入");
                    }
                }
                if (i == 10)
                    return;
                boolean isEntered;
                Room room = receiveRoomSelected(reader);
                if (room == null)
                    return;
                else {
                    ClientHandler clientHandler = new ClientHandler(clientSocket, room);
                    room.addClient(clientHandler);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

    private boolean receiveAccountInfo(Scanner scanner) {
        // 假设账号信息是一个简单的字符串，仅用于演示目的
        System.out.println("等待账号信息...");
        String accountInfo = scanner.nextLine();

        // TODO: 实现检查和验证账号信息的逻辑
        // 例如，你可以分割字符串以获取用户名和密码
        // 执行必要的验证并在匹配时返回true，否则返回false
        boolean isMatched = true;

        System.out.println("收到账号信息：" + accountInfo);
        return isMatched;
    }

    private Room receiveRoomSelected(Scanner scanner) {

        // 假设房间选择是一个简单的字符串，仅用于演示目的
        System.out.println("等待房间选择...");
        String roomSelected = scanner.nextLine();
        // TODO:添加字符处理逻辑
        // TODO: 实现处理房间选择的逻辑
        // 例如，你可以加入指定的房间
        System.out.println("收到房间选择：" + roomSelected);
        Room room = new Room(roomSelected);

        return room;
    }

}
