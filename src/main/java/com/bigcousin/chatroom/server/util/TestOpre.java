package main.java.com.bigcousin.chatroom.server.util;

import main.java.com.bigcousin.chatroom.common.info.user.UserInfo;
import main.java.com.bigcousin.chatroom.common.message.ChatMessage;
import main.java.com.bigcousin.chatroom.common.message.Message;
import main.java.com.bigcousin.chatroom.common.message.MessageType;
import main.java.com.bigcousin.chatroom.server.app.ServerAPP;
import main.java.com.bigcousin.chatroom.server.service.ChatServer;

public class TestOpre extends Thread {
    private ChatServer chatServer;

    public TestOpre(ChatServer chatServer) {
        this.chatServer = chatServer;
    }

    public void run() {
        chatServer.broadcastMessage(new ChatMessage("hello", new UserInfo("Bigvousin")));
    }
}
