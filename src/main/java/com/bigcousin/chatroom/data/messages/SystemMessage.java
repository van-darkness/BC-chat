package main.java.com.bigcousin.chatroom.data.messages;

import main.java.com.bigcousin.chatroom.data.messages.enums.MessageSource;
import main.java.com.bigcousin.chatroom.data.messages.enums.MessageType;

import java.awt.*;

public class SystemMessage extends BaseMessage{

    private MessageType type;
    private Color color;
    private Font font;
    private String content;
    private MessageSource source; // 使用 MessageSource 枚举类型表示消息来源
    public SystemMessage(String content, MessageType messageType, MessageSource messageSource) {
        super(messageType, messageSource);
        this.color = getDefaultColor(super.getMessageType());
        this.font = getDefaultFont();
        this.content=content;
    }

    public MessageType getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public Font getFont() {
        return font;
    }

    public String getContent() {
        return content;
    }

    public MessageSource getSource() {
        return super.getMessageSource();
    }

    private Font getDefaultFont() {
        return new Font("Arial", Font.PLAIN, 12);
    }

    private Color getDefaultColor(MessageType type) {
        switch (type) {
            case INFO:
                return Color.BLUE;
            case WARNING:
                return Color.ORANGE;
            case ERROR:
                return Color.RED;
            default:
                return Color.BLACK;
        }
    }
}
