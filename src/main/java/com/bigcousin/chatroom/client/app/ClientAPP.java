package main.java.com.bigcousin.chatroom.client.app;

import main.java.com.bigcousin.chatroom.client.core.business.service.Community;
import main.java.com.bigcousin.chatroom.client.core.business.service.User;

import java.net.Socket;

public class ClientAPP {
    private Community community;
    private User user;
public ClientAPP(String serverAddress,int port){

    user=new User();
    community=user .logIn(serverAddress,port);
}
    public static void main(String[] args) {
        ClientAPP client = new ClientAPP("127.0.0.1",8888);
    }
}
