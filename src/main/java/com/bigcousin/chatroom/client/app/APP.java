package main.java.com.bigcousin.chatroom.client.app;

import main.java.com.bigcousin.chatroom.client.ChatClientUI;

public class APP {
    public static void main(String[] args) {
        ChatClientUI chatClientUI = new ChatClientUI("172.22.164.242", 12345);
        chatClientUI.display();
    }
}
