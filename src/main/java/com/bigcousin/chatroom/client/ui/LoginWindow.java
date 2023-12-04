package main.java.com.bigcousin.chatroom.client.ui;

import javax.swing.*;

import main.java.com.bigcousin.chatroom.data.user.NotLoggedInStatus;
import main.java.com.bigcousin.chatroom.server.message.LogInMessage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class LoginWindow extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private NotLoggedInStatus notLoggedInStatus;

    public LoginWindow(NotLoggedInStatus notLoggedInStatus) {
        super("BCchat");
        this.notLoggedInStatus = notLoggedInStatus;
        // 设置窗口标题

        ImageIcon icon = new ImageIcon("image.jpg");
        Image image = icon.getImage();
        this.setIconImage(image);
        // 设置窗口关闭时的操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建账号标签和文本框
        JLabel usernameLabel = new JLabel("账号:");
        usernameField = new JTextField(20);

        // 创建密码标签和密码框
        JLabel passwordLabel = new JLabel("密码:");
        passwordField = new JPasswordField(20);

        // 创建登录按钮
        JButton loginButton = new JButton("登录");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        // 创建面板并设置布局
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 添加组件到面板
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);

        // 添加占位组件
        panel.add(new JLabel());
        panel.add(new JLabel());

        // 创建按钮面板并设置布局
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(loginButton);

        // 将面板和按钮面板添加到窗口，使用BorderLayout管理
        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // 设置字体
        Font font = new Font("宋体", Font.PLAIN, 16);
        usernameLabel.setFont(font);
        usernameField.setFont(font);
        passwordLabel.setFont(font);
        passwordField.setFont(font);
        loginButton.setFont(font);

        // 设置按钮背景色
        loginButton.setBackground(new Color(70, 130, 180)); // 深蓝色
        loginButton.setForeground(Color.WHITE); // 白色

        // 设置窗口背景色
        panel.setBackground(new Color(240, 240, 240)); // 淡灰色
        getContentPane().setBackground(new Color(240, 240, 240));

        // 设置窗口大小
        setSize(300, 200);

        // 居中显示窗口
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void login() {
        // 获取输入的账号和密码
        String acount = usernameField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);

        // 在实际应用中，这里可以加入验证逻辑
        // 此处只是简单地打印输入的账号和密码
        System.out.println("登录账号: " + acount);
        System.out.println("登录密码: " + password);
        LogInMessage messages = new LogInMessage(acount, password);
        
        try {
            notLoggedInStatus.setSocket(new Socket(notLoggedInStatus.getServerAddress(), notLoggedInStatus.getPort()));
            OutputStream outputStream = notLoggedInStatus.getSocket().getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            
            objectOutputStream.writeObject(messages);

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 在这里可以添加验证逻辑，与服务器建立连接并且等待服务器响应

        // 清空密码框
        passwordField.setText("");
    }
}
