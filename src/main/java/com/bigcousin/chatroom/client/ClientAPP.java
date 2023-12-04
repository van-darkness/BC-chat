package main.java.com.bigcousin.chatroom.client;

import java.net.InetAddress;

import main.java.com.bigcousin.chatroom.data.user.NotLoggedInStatus;
import main.java.com.bigcousin.chatroom.data.user.UserStatus;

public class ClientAPP {
    InetAddress computer;
    UserStatus userStatus;
    String serverAddress;
    int port;

    public ClientAPP(String serverAddress, int port) {
        this.port = port;
        this.serverAddress = serverAddress;
        userStatus = new NotLoggedInStatus();
        userStatus.login(serverAddress, port);
    }

    public static void main(String[] args) {
        ClientAPP clientAPP = new ClientAPP("172.22.164.242", 8888);
    }
}