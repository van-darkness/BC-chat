package main.java.com.bigcousin.chatroom.sever;

public class APP {
    public static void main(String[] args) {
        ChatServer server = new ChatServer(8888);
        server.start();
    }

}
