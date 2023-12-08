package main.java.com.bigcousin.chatroom.data.messages;

import main.java.com.bigcousin.chatroom.data.messages.enums.MessageSource;
import main.java.com.bigcousin.chatroom.data.messages.enums.MessageType;

public class ChatMessage extends BaseMessage{
    String content;
    String account;
    public ChatMessage(String content, MessageType messageType, MessageSource messageSource,String account) {
        super( messageType, messageSource);
        this.content=content;
        this.account=account;
    }
    //TODO:聊天信息类
}
