package main.java.com.bigcousin.chatroom.client.ui;

import main.java.com.bigcousin.chatroom.client.core.ChatClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatClientUI {
    private JFrame frame;
    private JTextField messageField;
    private JTextArea chatArea;
    private JTextField nicknameField;
    private JButton connectButton;
    private ChatClient chatClient;
    private String serverAddress;
    private int port;

    public ChatClientUI(String serverAddress, int port) {
        this.serverAddress = serverAddress;
        this.port = port;
        // 创建窗口
        frame = new JFrame("Chat Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        // 昵称输入
        nicknameField = new JTextField();
        connectButton = new JButton("Connect");
        JPanel northPanel = new JPanel(new GridLayout(1, 0));
        northPanel.add(nicknameField);
        northPanel.add(connectButton);
        frame.add(northPanel, BorderLayout.NORTH);

        // 聊天区域
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        frame.add(new JScrollPane(chatArea), BorderLayout.CENTER);

        // 消息输入
        messageField = new JTextField();
        frame.add(messageField, BorderLayout.SOUTH);

        // 添加事件监听器
        addListeners();
    }

    private void addListeners() {
        // 连接按钮事件
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nickname = nicknameField.getText().trim();
                if (!nickname.isEmpty()) {
                    //chatClient = new ChatClient(nickname, chatArea);
                    chatClient.connect(serverAddress, port);
                    messageField.setEditable(true);
                    nicknameField.setEditable(false);
                    connectButton.setEnabled(false);
                }
            }
        });

        // 消息发送事件
        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageField.getText().trim();
                if (!message.isEmpty()) {
//                    chatClient.sendMessage(message);
//                    messageField.setText("");
                }
            }
        });
    }

    public void display() {
        frame.setVisible(true);
    }

    // 其他 UI 相关方法
}
