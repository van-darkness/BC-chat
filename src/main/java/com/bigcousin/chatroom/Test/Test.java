package main.java.com.bigcousin.chatroom.Test;

import main.java.com.bigcousin.chatroom.client.app.ClientAPP;
import main.java.com.bigcousin.chatroom.server.app.ChatServerAPP;

public class Test {
    public static void main(String[] arg){
        int port=8888;
        ChatServerAPP chatServerAPP=new ChatServerAPP(port);
        ClientAPP clientAPP=new ClientAPP(chatServerAPP.getInetAddress().getHostAddress(),port);
    }
}
