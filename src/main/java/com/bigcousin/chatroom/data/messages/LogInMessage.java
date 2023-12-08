package main.java.com.bigcousin.chatroom.data.messages;

import main.java.com.bigcousin.chatroom.data.messages.enums.MessageSource;
import main.java.com.bigcousin.chatroom.data.messages.enums.MessageType;

import java.io.Serializable;

public class LogInMessage extends BaseMessage implements Serializable {
    private String acount;
    private String password;

    public LogInMessage(String acount, String password) {
        super(MessageType.INFO, MessageSource.USER);
        this.acount = acount;
        this.password = password;
    }

    public String getAcount() {
        return this.acount;
    }

    public String getPassword() {
        return this.password;
    }

}
