package main.java.com.bigcousin.chatroom.sever.message;

import java.awt.*;

public class SystemMessage {

    private MessageType type;
    private Color color;
    private Font font;
    private String content;
    private MessageSource source; // 使用 MessageSource 枚举类型表示消息来源

    public SystemMessage(MessageType info, String content, MessageSource source) {
        this.type = info;
        this.content = content;
        this.source = source;
        this.color = getDefaultColor(info);
        this.font = getDefaultFont();
    }

    public SystemMessage(String string, MessageSource messageSource) {
        content = string;
        source = messageSource;
        type = MessageType.INFO;
        this.color = getDefaultColor(type);
        this.font = getDefaultFont();
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
        return source;
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
