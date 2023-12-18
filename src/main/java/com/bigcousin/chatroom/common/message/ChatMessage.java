package main.java.com.bigcousin.chatroom.common.message;

import main.java.com.bigcousin.chatroom.common.info.user.UserInfo;

import java.io.Serializable;

// 聊天消息类
public class ChatMessage extends Message implements Serializable {
    private String content;
    private UserInfo userInfo;
    public ChatMessage(String message,UserInfo userInfo) {
        super(MessageType.CHAT);
        this.userInfo=userInfo;
        this.content = message;
    }

    public String getMessage() {
        return content;
    }
    public String toString() {
        return userInfo.getNickname()+":"+content;
    }
}