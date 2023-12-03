package main.java.com.bigcousin.chatroom.client;

import java.net.InetAddress;
import java.net.Socket;

import main.java.com.bigcousin.chatroom.client.user.NotLoggedInStatus;
import main.java.com.bigcousin.chatroom.client.user.UserCore;
import main.java.com.bigcousin.chatroom.client.user.UserStatus;

public class ClientAPP {
    InetAddress computer;
    UserStatus userStatus;

    public ClientAPP() {
        userStatus = new NotLoggedInStatus();
        userStatus.login();
    }

    public static void main(String[] args) {
        ClientAPP clientAPP = new ClientAPP();
    }

}