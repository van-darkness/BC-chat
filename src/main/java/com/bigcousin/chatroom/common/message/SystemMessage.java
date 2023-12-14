package main.java.com.bigcousin.chatroom.common.message;

public class SystemMessage extends Message{
    private String content;

    public SystemMessage(String content) {
        super(MessageType.SYSTEM_NOTE);
        this.content=content;
    }
}
