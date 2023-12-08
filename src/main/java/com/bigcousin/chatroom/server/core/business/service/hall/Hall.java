package main.java.com.bigcousin.chatroom.server.core.business.service.hall;

import main.java.com.bigcousin.chatroom.data.messages.ChatMessage;
import main.java.com.bigcousin.chatroom.data.user.UserInfo;
import main.java.com.bigcousin.chatroom.server.core.business.service.room.Room;
import main.java.com.bigcousin.chatroom.server.core.business.service.user.User;

import java.net.ServerSocket;
import java.util.ArrayList;

public class Hall implements Menageable_Hall{
    private ServerSocket serverSocket;
    private ArrayList<Room> RoomList;
    private ArrayList<User> UserList;
    private ArrayList<UserInfo> UserInfoList;
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

    @Override
    public void senGroupChatMessage(ChatMessage chatMessage, UserInfo userInfo) {

    }
}
