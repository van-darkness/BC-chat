package main.java.com.bigcousin.chatroom.client.core.business.service;

import main.java.com.bigcousin.chatroom.data.messages.ChatMessage;
import main.java.com.bigcousin.chatroom.data.messages.LogInMessage;
import main.java.com.bigcousin.chatroom.data.rooms.RoomInfo;
import main.java.com.bigcousin.chatroom.data.user.UserInfo;

import java.net.InetAddress;
import java.util.Scanner;

public class User extends Thread implements UserInteraction{

    private UserInfo userInfo;
    private RoomInfo roomInfo;
    private boolean isLogged;
    private Community community;

    public User() {

    }

    @Override
    public void run() {

    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public RoomInfo getRoomInfo() {
        return roomInfo;
    }

    public void setRoomInfo(RoomInfo roomInfo) {
        this.roomInfo = roomInfo;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    @Override
    public Community logIn(String serverAddress, int port) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your account: ");
        String account = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // 在这里你可以使用 account 和 password 进行登录操作，发送到服务器等
        // 你可能需要定义一个登录的消息类，将 account 和 password 封装起来发送给服务器
        community=new Community(serverAddress,port);
        LogInMessage logInMessage=new LogInMessage(account,password);
        community.send((Object)logInMessage);
        UserInfo userInfo=(UserInfo) community.receive();

        // 之后你可以处理服务器返回的用户信息等
        // 示例中只是简单地打印输入的账号和密码
        System.out.println("Logging in with account: " + account);
        System.out.println("Password: " + password);
        System.out.println("Welcome " + userInfo.getNickname()+"!");
        // 关闭 Scanner
        scanner.close();
        return community;
    }

    @Override
    public void selectRoom(RoomInfo roomInfo) {

    }

    @Override
    public void exitRoom() {

    }

    @Override
    public void logOut(String serverAddress, int port) {

    }

    @Override
    public void sendChatMessage(ChatMessage chatMessage) {

    }
}
