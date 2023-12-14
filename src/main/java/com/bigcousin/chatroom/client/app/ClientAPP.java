package main.java.com.bigcousin.chatroom.client.app;

import main.java.com.bigcousin.chatroom.client.core.ChatClient;

public class ClientAPP {
    public static void main(String[] args) {
        ChatClient chatClient=new ChatClient("Bigcousin");
        chatClient.connect("127.0.0.1",12345);
    }
}
