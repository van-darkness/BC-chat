package main.java.com.bigcousin.chatroom.server.message;

import java.io.Serializable;

public class LogInMessage implements Serializable {
    private String acount;
    private String password;

    public LogInMessage(String acount, String password) {
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
