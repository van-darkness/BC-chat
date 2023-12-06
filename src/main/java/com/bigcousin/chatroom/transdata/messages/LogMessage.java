package main.java.com.bigcousin.chatroom.transdata.messages;

import java.io.Serializable;

public class LogMessage implements Serializable {
    private String acount;
    private String password;

    public LogMessage(String acount, String password) {
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
