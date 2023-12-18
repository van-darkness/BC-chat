package main.java.com.bigcousin.chatroom.client.ui;

import main.java.com.bigcousin.chatroom.client.controller.MainController;
import main.java.com.bigcousin.chatroom.client.core.ChatClient;
import main.java.com.bigcousin.chatroom.common.info.room.RoomInfo;
import main.java.com.bigcousin.chatroom.common.info.user.UserInfo;
import main.java.com.bigcousin.chatroom.common.message.ChatMessage;
import main.java.com.bigcousin.chatroom.common.message.MessageType;
import main.java.com.bigcousin.clock.Clockrunner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Clock;

public class ChatRoomWindow extends JFrame {
    private Clockrunner clockrunner;
    private MainController controller;
    private ChatClient chatClient;
    private JPanel messagePanel;
    private JTextField inputField;
    private JButton sendButton;
    private JScrollPane scrollPane;
    private RoomInfo roomInfo;
    private JButton clockButton; // 新增 Clock 按钮
    private boolean isClockRunning = false; // 用于跟踪时钟状态
    public ChatRoomWindow(MainController controller, ChatClient chatClient) {
        clockrunner=new Clockrunner();
        clockrunner.setVisible(false);
        clockrunner.start();
        this.controller = controller;
        this.chatClient = chatClient;
        roomInfo=chatClient.getRoomInfo();
        initializeUI();
        // 设置窗口在屏幕中间显示
        setLocationRelativeTo(null);

    }

    private void initializeUI() {
        ImageIcon icon=new ImageIcon("src/main/resources/images/image.jpg");
        setIconImage(icon.getImage());
        setTitle(roomInfo.getName());
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(new Color(240, 240, 240)); // 设置窗口背景色

        // 消息区域
        messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(messagePanel);
        add(scrollPane, BorderLayout.CENTER);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        add(scrollPane, BorderLayout.CENTER);

        // 输入区域
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // 添加边距

        inputField = new JTextField();
        inputField.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        inputPanel.add(inputField, BorderLayout.CENTER);

        // 按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        sendButton = new JButton("Send");
        sendButton.setFont(new Font("Sans Serif", Font.BOLD, 12));
        sendButton.setBackground(new Color(100, 149, 237)); // 蓝色按钮
        sendButton.setForeground(Color.WHITE); // 白色文字
        sendButton.addActionListener(e -> sendChatMessage());

        clockButton = createStyledButton("Clock", new Color(100, 149, 237), new Color(70, 130, 180));
        clockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isClockRunning) {
                    clickStop();
                } else {
                    clockRun();
                }
                isClockRunning = !isClockRunning; // 切换时钟状态
            }
        });

        // 将按钮添加到按钮面板
        buttonPanel.add(sendButton);
        buttonPanel.add(clockButton);

        // 将按钮面板添加到输入面板的东侧
        inputPanel.add(buttonPanel, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);

        // 设置回车键发送消息
        getRootPane().setDefaultButton(sendButton);

        add(inputPanel, BorderLayout.SOUTH);

        // 设置回车键发送消息
        getRootPane().setDefaultButton(sendButton);
    }

    private void sendChatMessage() {
        String message = inputField.getText();
        if (!message.isEmpty()) {
            chatClient.sendMessage(new ChatMessage(message,chatClient.getUserInfo()));
            inputField.setText(""); // 清空输入框
        }
    }

    // 用于从ChatClient接收消息的方法
    public void receiveChatMessage(ChatMessage chatMessage) {
        UserInfo userInfo = chatMessage.getUserInfo();
        Color userColor = userInfo.getColor(); // 假设您已经实现了 getUserColor 方法
        BubblePanel bubble = new BubblePanel(userInfo.getNickname(), chatMessage.getMessage(), userColor);

        SwingUtilities.invokeLater(() -> {
            messagePanel.add(bubble);
            messagePanel.revalidate();
            messagePanel.repaint();
            scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
        });
    }
    private void clockRun(){
        clockrunner.setVisible(true);
    }
    private void clickStop(){
        clockrunner.setVisible(false);
    }
    private JButton createStyledButton(String text, Color bgColor, Color hoverColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE); // 白色文本
        button.setFont(new Font("Sans Serif", Font.BOLD, 12));
        button.setBorderPainted(false); // 不绘制边框
        button.setFocusPainted(false); // 不绘制焦点边框
        button.setContentAreaFilled(false); // 不填充内容区域
        button.setOpaque(true); // 设置不透明以显示背景色

        // 鼠标悬停时改变背景色
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(bgColor);
            }
        });

        return button;
    }
}
