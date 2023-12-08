package main.java.com.bigcousin.chatroom.data.messages;

import main.java.com.bigcousin.chatroom.data.messages.enums.MessageSource;
import main.java.com.bigcousin.chatroom.data.messages.enums.MessageType;

import java.io.Serializable;

public class BaseMessage implements Serializable {
    private MessageType messageType;
    private MessageSource messageSource;

    public BaseMessage(MessageType messageType, MessageSource messageSource) {

        this.messageType = messageType;
        this.messageSource = messageSource;
    }


    public MessageType getMessageType() {
        return messageType;
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }
}
