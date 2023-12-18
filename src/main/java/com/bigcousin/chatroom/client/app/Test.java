package main.java.com.bigcousin.chatroom.client.app;

import main.java.com.bigcousin.chatroom.client.core.ChatClient;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String serverAddress=scanner.next();
        ChatClient chatClient = new ChatClient(serverAddress, 8888);
        System.out.println("hello,Cui");
        chatClient.login("Bigcousin");
        chatClient.sendRoomSelection("BigCousin'Chatroom1");
        //chatClient.getUserInfo();
    }
}
