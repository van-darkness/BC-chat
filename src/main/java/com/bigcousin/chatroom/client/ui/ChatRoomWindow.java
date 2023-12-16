package main.java.com.bigcousin.chatroom.client.ui;

import main.java.com.bigcousin.chatroom.client.controller.MainController;
import main.java.com.bigcousin.chatroom.client.core.ChatClient;

import javax.swing.*;

public class ChatRoomWindow extends JFrame {
    private MainController controller;
    private ChatClient chatClient;

    public ChatRoomWindow(MainController controller, ChatClient chatClient) {
        this.controller = controller;
        this.chatClient = chatClient;
        // ... 窗口初始化代码 ...
    }

    // 聊天逻辑

}
