package main.java.com.bigcousin.chatroom.common.message;

import java.io.Serializable;

// 登录消息类
public class LoginMessage extends Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nickname;

    public LoginMessage(String nickname) {
        super(MessageType.LOGIN);
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
}