package main.java.com.bigcousin.chatroom.server.core.business.service.room;

import main.java.com.bigcousin.chatroom.server.core.business.service.user.User;

public interface Manageble_Room {
    void addUser(User user);
    void kickUser(User user);
    void borderCast();
    void close();
}
