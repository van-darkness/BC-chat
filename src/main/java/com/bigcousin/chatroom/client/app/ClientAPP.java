package main.java.com.bigcousin.chatroom.client.app;

import com.sun.tools.javac.Main;
import main.java.com.bigcousin.chatroom.client.controller.MainController;
import main.java.com.bigcousin.chatroom.client.core.ChatClient;

import java.util.Scanner;

public class ClientAPP {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入目标ip地址");
        String ip=scanner.next();
        MainController mainController = new MainController(ip, 8888);
        mainController.showLoginWindows();
    }
}
