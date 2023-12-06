package main.java.com.bigcousin.chatroom.transdata.messages;

import main.java.com.bigcousin.chatroom.transdata.messages.enums.MessageSource;
import main.java.com.bigcousin.chatroom.transdata.messages.enums.MessageType;

import java.io.Serializable;

public class BaseMessage implements Serializable {
    private String content;
    private MessageType messageType;
    private MessageSource messageSource;

    public BaseMessage(String content, MessageType messageType, MessageSource messageSource) {
        this.content = content;
        this.messageType = messageType;
        this.messageSource = messageSource;
    }

    public String getContent() {
        return content;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }
}
