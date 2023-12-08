package main.java.com.bigcousin.chatroom.client.core.business.service;

import main.java.com.bigcousin.chatroom.data.messages.ChatMessage;
import main.java.com.bigcousin.chatroom.data.rooms.RoomInfo;

public interface UserInteraction {
    // 以下是用户可以进行的操作
    Community logIn(String serverAddress, int port);

    void selectRoom(RoomInfo roomInfo);

    void exitRoom();

    void logOut(String serverAddress, int port);

    void sendChatMessage(ChatMessage chatMessage);

}
