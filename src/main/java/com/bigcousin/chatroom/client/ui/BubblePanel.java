package main.java.com.bigcousin.chatroom.client.ui;

import javax.swing.*;
import java.awt.*;

public class BubblePanel extends JPanel {
    private String nickname;
    private String message;
    private Color backgroundColor;

    public BubblePanel(String nickname, String message, Color backgroundColor) {
        this.nickname = nickname;
        this.message = message;
        this.backgroundColor = backgroundColor;
        setOpaque(false); // 设置为透明背景
        setPreferredSize(new Dimension(300, 80)); // 设置首选大小
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 60)); // 设置最大高度
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // 绘制气泡
        g2d.setColor(backgroundColor);
        g2d.fillRoundRect(10, 10, getWidth() - 20, getHeight() - 20, 25, 25);

        // 绘制文字
        g2d.setColor(Color.BLACK);
        g2d.drawString(nickname, 20, 25);
        g2d.drawString(message, 20, 40);
    }
}
