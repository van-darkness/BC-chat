package main.java.com.bigcousin.chatroom.client.app;

import com.sun.tools.javac.Main;
import main.java.com.bigcousin.chatroom.client.controller.MainController;
import main.java.com.bigcousin.chatroom.client.core.ChatClient;

public class ClientAPP {
    public static void main(String[] args) {
        MainController mainController = new MainController("172.23.250.86", 8888);
        mainController.showLoginWindows();
    }
}
