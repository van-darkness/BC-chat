package main.java.com.bigcousin.chatroom.data.messages;

import main.java.com.bigcousin.chatroom.data.messages.enums.MessageSource;
import main.java.com.bigcousin.chatroom.data.messages.enums.MessageType;

public class ChatMessage extends BaseMessage{
    public ChatMessage(String content, MessageType messageType, MessageSource messageSource) {
        super(content, messageType, messageSource);
    }
    //TODO:聊天信息类
}
