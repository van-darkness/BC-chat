package main.java.com.bigcousin.chatroom.client;

import java.net.InetAddress;

import main.java.com.bigcousin.chatroom.client.core.NotLoggedInStatus;
import main.java.com.bigcousin.chatroom.client.core.UserStatus;

public class ClientAPP {
    InetAddress computer;
    UserStatus userCore;
    String serverAddress;
    int port;

    public ClientAPP(String serverAddress, int port) {
        this.port = port;
        this.serverAddress = serverAddress;
        userCore = new NotLoggedInStatus();
        userCore.login(serverAddress, port,userCore);
    }

    public static void main(String[] args) {
        ClientAPP clientAPP = new ClientAPP("172.22.164.242", 8888);
    }
}