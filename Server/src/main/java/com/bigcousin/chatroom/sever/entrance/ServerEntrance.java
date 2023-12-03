package main.java.com.bigcousin.chatroom.sever.entrance;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import main.java.com.bigcousin.chatroom.sever.message.LogInMessage;
import main.java.com.bigcousin.chatroom.sever.message.MessageSource;
import main.java.com.bigcousin.chatroom.sever.message.SystemMessage;
import main.java.com.bigcousin.chatroom.sever.ui.LogOutputWindow;

public class ServerEntrance implements Runnable {
    ServerSocket serverSocket;
    LogOutputWindow logOutputWindow;

    public ServerEntrance(ServerSocket serverSocket, LogOutputWindow logOutputWindow) {
        this.serverSocket = serverSocket;
        this.logOutputWindow = logOutputWindow;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                if (socket != null) {
                    SystemMessage message = new SystemMessage(
                            main.java.com.bigcousin.chatroom.sever.message.MessageType.INFO,
                            "客户端接入:" + socket.getInetAddress().getHostAddress(), MessageSource.SYSTEM);
                    logOutputWindow.appendSystemMessage(message);
                }

                // 方案，客户端方面输入账号和密码再连接，然后建立套接字连接，连接成功后服务端自动从本地数据库匹配账号密码
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                try {
                    LogInMessage logInMessage = (LogInMessage) objectInputStream.readObject();
                    // 测试登录信息流接收
                    logOutputWindow
                            .appendSystemMessage(new SystemMessage(logInMessage.getAcount(), MessageSource.USER));
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

    private void addClientToServer() {

    }
}
