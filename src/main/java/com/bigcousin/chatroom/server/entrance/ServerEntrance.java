package main.java.com.bigcousin.chatroom.server.entrance;

import main.java.com.bigcousin.chatroom.data.user.User;
import main.java.com.bigcousin.chatroom.server.message.*;
import main.java.com.bigcousin.chatroom.server.ui.LogOutputWindow;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class ServerEntrance implements Runnable {
    ServerSocket serverSocket;
    LogOutputWindow logOutputWindow;

    public ServerEntrance(ServerSocket serverSocket, LogOutputWindow logOutputWindow) {
        this.serverSocket = serverSocket;
        this.logOutputWindow = logOutputWindow;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                if (socket != null) {
                    SystemMessage message = new SystemMessage(
                            MessageType.INFO,
                            "客户端接入:" + socket.getInetAddress().getHostAddress(), MessageSource.SYSTEM);
                    logOutputWindow.appendSystemMessage(message);
                }

                // 方案，客户端方面输入账号和密码再连接，然后建立套接字连接，连接成功后服务端自动从本地数据库匹配账号密码
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                LogInMessage logInMessage = (LogInMessage)objectInputStream.readObject();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static User initializeUserDatabaseFromFile(String filePath) {
        User user = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            if ((line = reader.readLine()) != null) {
                String[] userInfo = line.split("\t");
                if (userInfo.length == 4) {
                    String role = userInfo[0];
                    String nickname = userInfo[1];
                    String account = userInfo[2];
                    String password = userInfo[3];
                    user = new User(nickname, account, password, role);
                } else if (userInfo.length == 3) {
                    String role = userInfo[0];
                    String nickname = userInfo[1];
                    String account = userInfo[2];
                    user = new User(nickname, role, account);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
