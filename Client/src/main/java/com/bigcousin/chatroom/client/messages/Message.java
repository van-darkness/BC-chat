package main.java.com.bigcousin.chatroom.client.messages;

import java.io.Serializable;

import main.java.com.bigcousin.chatroom.client.user.User;

public class Message implements Serializable {
    private User user;
    private String string;

    public Message(User user, String string) {
        this.string = string;
        this.user = user;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "" + user.getNickname() + ": " + string;
    }
}
