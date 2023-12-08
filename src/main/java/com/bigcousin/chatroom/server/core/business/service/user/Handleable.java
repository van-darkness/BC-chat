package main.java.com.bigcousin.chatroom.server.core.business.service.user;

import main.java.com.bigcousin.chatroom.data.rooms.RoomInfo;

public interface Handleable {
    void sendMessage();
    void exitRoom(RoomInfo roomInfo);
    void logOut();
    void selectRoom(RoomInfo roomInfo);
}
