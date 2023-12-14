package main.java.com.bigcousin.chatroom.common.message;

import java.io.Serializable;

// 基础消息类
public class Message implements Serializable {
    protected static final long serialVersionUID = 1L;

    // 定义消息类型

    private MessageType messageType;

    public Message(MessageType messageType) {
        this.messageType = messageType;
    }

    public MessageType getType() {
        return messageType;
    }
}