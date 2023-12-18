package main.java.com.bigcousin.chatroom.client.controller;

import main.java.com.bigcousin.chatroom.client.core.ChatClient;
import main.java.com.bigcousin.chatroom.client.ui.ChatRoomWindow;
import main.java.com.bigcousin.chatroom.client.ui.LoginWindow;
import main.java.com.bigcousin.chatroom.client.ui.RoomSelectionWindow;

public class MainController {
    private ChatClient chatClient;
    private LoginWindow loginWindow;
    private ChatRoomWindow chatRoomWindow;
    private RoomSelectionWindow roomSelectionWindow;
    private String serverAddress;
    private int port;
    public MainController(String serverAddress,int port){
        this.serverAddress=serverAddress;
        this.port=port;
        chatClient = new ChatClient(serverAddress,port); // 创建 ChatClient 实例
        //等待登录窗口为chatClient设置信息
        loginWindow = new LoginWindow(this, chatClient);
    }
    public void showLoginWindows(){
        loginWindow.setVisible(true);
    }

    public void showRoomSelectionWindow() {
        loginWindow.setVisible(false);
        roomSelectionWindow=new RoomSelectionWindow(this,chatClient);
        roomSelectionWindow.setVisible(true);
    }


    public void showChatRoomWindow(){
        chatRoomWindow = new ChatRoomWindow(this, chatClient);
        roomSelectionWindow.setVisible(false);
        chatRoomWindow.setVisible(true);
    }

    public LoginWindow getLoginWindow() {
        return loginWindow;
    }

    public ChatRoomWindow getChatRoomWindow() {
        return chatRoomWindow;
    }

    public RoomSelectionWindow getRoomSelectionWindow() {
        return roomSelectionWindow;
    }
}
