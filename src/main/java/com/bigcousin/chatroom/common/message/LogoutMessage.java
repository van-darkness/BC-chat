package main.java.com.bigcousin.chatroom.common.message;

import main.java.com.bigcousin.chatroom.common.info.user.UserInfo;

public class LogoutMessage extends Message{
    UserInfo userInfo;
    public LogoutMessage(UserInfo userInfo) {
        super(MessageType.LOGOUT);
        this.userInfo=userInfo;
    }
}
