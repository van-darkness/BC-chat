package main.java.com.bigcousin.chatroom.client.app;

import com.sun.tools.javac.Main;
import main.java.com.bigcousin.chatroom.client.controller.MainController;
import main.java.com.bigcousin.chatroom.client.core.ChatClient;

public class ClientAPP {
    public static void main(String[] args) {
        MainController mainController=new MainController("127.0.0.1",12345);
        mainController.showLoginWindows();
    }
}
