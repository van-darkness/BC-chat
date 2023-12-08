package main.java.com.bigcousin.chatroom.server.core.business.service.room;

import main.java.com.bigcousin.chatroom.data.rooms.RoomInfo;
import main.java.com.bigcousin.chatroom.server.core.business.service.user.User;

import java.util.ArrayList;

public class Room implements Manageble_Room{
    private RoomInfo roomInfo;
    private ArrayList<User> userList;

    @Override
    public void addUser(User user) {

    }

    @Override
    public void kickUser(User user) {

    }

    @Override
    public void borderCast() {

    }

    @Override
    public void close() {

    }
}
