package main.java.com.bigcousin.chatroom.client.ui;

import main.java.com.bigcousin.chatroom.client.controller.MainController;
import main.java.com.bigcousin.chatroom.client.core.ChatClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
    private MainController controller;
    private ChatClient chatClient;
    private JTextField nicknameField;
    private JButton loginButton;

    public LoginWindow(MainController controller, ChatClient chatClient) {
        this.controller = controller;
        this.chatClient = chatClient;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("BC Chat");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        setLayout(new BorderLayout());

        // 创建并添加渐变背景的面板
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int width = getWidth();
                int height = getHeight();
                Color color1 = Color.BLUE;
                Color color2 = Color.WHITE;
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, width, height);
            }
        };
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        add(panel);

        // 空白区域
        panel.add(Box.createVerticalGlue());

        // 文本框
        nicknameField = new JTextField(15);
        nicknameField.setText("Nickname");
        nicknameField.setMaximumSize(nicknameField.getPreferredSize()); // 设置最大大小为首选大小
        nicknameField.setAlignmentX(Component.CENTER_ALIGNMENT); // 水平居中对齐
        panel.add(nicknameField);

        // 空白区域
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        // 登录按钮
        loginButton = new JButton("Login");
        // 登录按钮的事件处理
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nickname = nicknameField.getText().trim();
                if (!nickname.isEmpty()) {
                    chatClient.login(nickname); // 登录逻辑
                    // 根据需要切换到其他窗口，例如房间选择界面
                    controller.showRoomSelectionWindow();
                } else {
                    JOptionPane.showMessageDialog(LoginWindow.this,
                            "Nickname cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        loginButton.setContentAreaFilled(false); // 使按钮透明
        loginButton.setOpaque(true); // 允许绘制背景颜色
        loginButton.setBackground(new Color(135, 206, 250)); // 设置背景颜色
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT); // 水平居中对齐
        panel.add(loginButton);

        // 更多空白区域
        panel.add(Box.createVerticalGlue());

        // 设置窗口图标
        ImageIcon icon = new ImageIcon("src/main/resources/images/image.jpg");
        Image image = icon.getImage();
        setIconImage(image);

        setVisible(true);
    }

    // 其他方法...
}
