package main.java.com.bigcousin.chatroom.server.app;

import main.java.com.bigcousin.chatroom.data.messages.enums.MessageType;
import main.java.com.bigcousin.chatroom.data.user.UserInfo;
import main.java.com.bigcousin.chatroom.server.core.business.service.ServerEntrance;
import main.java.com.bigcousin.chatroom.data.messages.enums.MessageSource;
import main.java.com.bigcousin.chatroom.data.messages.SystemMessage;
import main.java.com.bigcousin.chatroom.server.ui.LogOutputWindow;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.ArrayList;

public class ChatServerAPP {
    private int port;
    private InetAddress inetAddress;
    private LogOutputWindow logOutputWindow;
    private ServerSocket serverSocket;
    private ArrayList<Thread> entranceList;
    private ArrayList<UserInfo> userInfoArrayList;

    public ChatServerAPP(int port) {
        logOutputWindow = new LogOutputWindow();
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
            this.inetAddress = InetAddress.getLocalHost();
            System.out.println("服务器已初始化;" + "ip地址:" + inetAddress.getHostAddress() + ";端口:" + port);
            SystemMessage systemMessage = new SystemMessage(
                    "服务器已初始化;" + "ip地址:" + inetAddress.getHostAddress() + ";端口:" + port,
                    MessageType.INFO,MessageSource.SYSTEM);
            logOutputWindow.appendSystemMessage(systemMessage);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void start() {

    }
    public void addUser(UserInfo userInfo){
        userInfoArrayList.add(userInfo);
    }
    public InetAddress getInetAddress() {
        return inetAddress;
    }
    public static void main(String[] args) {
        ChatServerAPP server = new ChatServerAPP(8888);
        server.start();
    }


}
