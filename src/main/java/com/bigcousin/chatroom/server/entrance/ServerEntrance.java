package main.java.com.bigcousin.chatroom.server.entrance;

import main.java.com.bigcousin.chatroom.data.messages.LogMessage;
import main.java.com.bigcousin.chatroom.data.messages.enums.MessageSource;
import main.java.com.bigcousin.chatroom.data.messages.enums.MessageType;
import main.java.com.bigcousin.chatroom.data.messages.SystemMessage;
import main.java.com.bigcousin.chatroom.data.user.UserInfo;
import main.java.com.bigcousin.chatroom.server.ChatServer;
import main.java.com.bigcousin.chatroom.server.ui.LogOutputWindow;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class ServerEntrance implements Runnable {
    ServerSocket serverSocket;
    LogOutputWindow logOutputWindow;
    ChatServer server;

    public ServerEntrance(ChatServer server, ServerSocket serverSocket, LogOutputWindow logOutputWindow) {
        this.serverSocket = serverSocket;
        this.logOutputWindow = logOutputWindow;
        this.server=server;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                if (socket != null) {

                    logOutputWindow.appendSystemMessage(new SystemMessage("客户端接入:" + socket.getInetAddress().getHostAddress(),
                            MessageType.INFO,
                            MessageSource.SYSTEM));

                }

                // 方案，客户端方面输入账号和密码再连接，然后建立套接字连接，连接成功后服务端自动从本地数据库匹配账号密码
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                LogMessage logMessage = (LogMessage)objectInputStream.readObject();
                SystemMessage newMessage=new SystemMessage(logMessage.getAcount()+" Connected!",MessageType.INFO,MessageSource.USER);
                logOutputWindow.appendSystemMessage(newMessage);
                UserInfo newUserInfo =findUserByLogInMessage("D:/Datas/JavaProjects/BC chat/UserDatas.txt", logMessage);
                if(newUserInfo !=null){
                    logOutputWindow.appendSystemMessage(new SystemMessage("用户类生成:" + newUserInfo.getNickname(),
                            MessageType.INFO,
                            MessageSource.SYSTEM));
                    //TODO:返回User类给客户端，客户端在接收到类后结束登陆操作，进入可选择房间的状态
                    //TODO:将用户类加入用户列表，创建新线程进行管理
                    server.addUser(newUserInfo);
                    OutputStream outputStream=socket.getOutputStream();
                    ObjectOutputStream objectOutputStream1=new ObjectOutputStream(outputStream);
                    objectOutputStream1.writeObject(newUserInfo);
                }
                else{
                    //TODO:返回一个错误信息给客户端然后退出线程，释放线程资源

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static UserInfo findUserByLogInMessage(String filePath, LogMessage logMessage) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userInfo = line.split("\t");
                if (userInfo.length == 4) {
                    String role = userInfo[0];
                    String nickname = userInfo[1];
                    String account = userInfo[2];
                    String password = userInfo[3];

                    // 检查账号和密码是否匹配
                    if (account.equals(logMessage.getAcount()) && password.equals(logMessage.getPassword())) {
                        return new UserInfo(nickname, account, password, role);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // 返回 null 表示未找到匹配的用户信息
    }
}
