package main.java.com.bigcousin.chatroom.client.app;

import main.java.com.bigcousin.chatroom.client.controller.MainController;
import main.java.com.bigcousin.chatroom.client.core.ChatClient;

public class Test {
    public static void main(String[] args){
        ChatClient chatClient = new ChatClient("127.0.0.1", 12345);
        chatClient.login("Bigcousin");

    }
}
