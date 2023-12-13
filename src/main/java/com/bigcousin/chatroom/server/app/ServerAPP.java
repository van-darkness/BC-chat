package server.app;

import server.service.ChatServer;

public class ServerAPP {
    public static void main(String[] args) {
        try {
            ChatServer chatServer = new ChatServer();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
