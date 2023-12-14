package main.java.com.bigcousin.chatroom.client.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomSelectionUI {

    public static void main(String[] args) {
        // 创建窗口
        JFrame frame = new JFrame("房间选择");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLayout(new BorderLayout());

        // 创建并添加标签和按钮
        JLabel roomLabel = new JLabel("房间: 固定聊天室", SwingConstants.CENTER);
        JButton enterButton = new JButton("进入房间");
        frame.add(roomLabel, BorderLayout.CENTER);
        frame.add(enterButton, BorderLayout.SOUTH);

        // 添加按钮的事件监听器
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("进入房间按钮被点击");
                // 在这里添加进入房间的逻辑
            }
        });

        // 显示窗口
        frame.setVisible(true);
    }
}
