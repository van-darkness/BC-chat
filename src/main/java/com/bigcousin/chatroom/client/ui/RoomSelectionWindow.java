package main.java.com.bigcousin.chatroom.client.ui;

import main.java.com.bigcousin.chatroom.client.controller.MainController;
import main.java.com.bigcousin.chatroom.client.core.ChatClient;
import main.java.com.bigcousin.chatroom.common.info.room.RoomInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class RoomSelectionWindow extends JFrame {
    private MainController controller;
    private ChatClient chatClient;
    private JPanel roomPanel;
    private List<RoomInfo> roomInfos;
    private JScrollPane scrollPane;
    public RoomSelectionWindow(MainController controller, ChatClient chatClient) {

        this.controller = controller;
        this.chatClient = chatClient;
        chatClient.addWindow(this);
        ImageIcon icon=new ImageIcon("src/main/resources/images/image.jpg");
        setIconImage(icon.getImage());
        chatClient.refreshRoomList();
        roomInfos=chatClient.getRoomInfos();

        initializeUI();
        // 设置窗口在屏幕中间显示
        setLocationRelativeTo(null);
    }
    private void initializeUI() {
        setTitle("Select a Room");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 初始化 roomPanel 并设置为 BoxLayout
        roomPanel = new JPanel();
        roomPanel.setLayout(new BoxLayout(roomPanel, BoxLayout.Y_AXIS));

        // 创建并添加 JScrollPane
        scrollPane = new JScrollPane(roomPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.CENTER);

        // 添加刷新按钮
        Color buttonColor = new Color(100, 149, 237); // 蓝色
        Color buttonHoverColor = new Color(70, 130, 180); // 悬停时的颜色
        JButton refreshButton = createStyledButton("Refresh", buttonColor, buttonHoverColor);
        refreshButton.addActionListener(e -> chatClient.requestRoomInfosFromServer());
        add(refreshButton, BorderLayout.SOUTH);
    }

    private void updateRoomListUI() {
        roomPanel.removeAll(); // 清除现有的房间信息

        List<RoomInfo> rooms = chatClient.getRoomInfos();
        for (RoomInfo room : rooms) {
            JPanel roomEntry = new JPanel(new BorderLayout(10, 10)); // 使用 BorderLayout
            roomEntry.setBackground(new Color(230, 230, 250)); // 设置背景颜色
            roomEntry.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true)); // 设置边框
            roomEntry.setPreferredSize(new Dimension(roomPanel.getWidth(), 100)); // 设置首选大小

            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            infoPanel.setOpaque(false); // 设置为透明以显示 roomEntry 的背景色

            JLabel nameLabel = new JLabel("Room: " + room.getName());
            nameLabel.setFont(new Font("Arial", Font.BOLD, 12));
            infoPanel.add(nameLabel);

            JLabel sizeLabel = new JLabel("Max size: " + room.getMax_size());
            sizeLabel.setFont(new Font("Arial", Font.PLAIN, 11));
            infoPanel.add(sizeLabel);

            JLabel currentLabel = new JLabel("Current: " + room.getCurrent_num());
            currentLabel.setFont(new Font("Arial", Font.PLAIN, 11));
            infoPanel.add(currentLabel);
            // 设置房间条目的最小和最大尺寸
            roomEntry.setMinimumSize(new Dimension(roomPanel.getWidth(), 20)); // 最小高度
            roomEntry.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50)); // 最大高度为100

            roomEntry.add(infoPanel, BorderLayout.CENTER); // 添加信息面板到中间

            JButton enterButton = createFlatButton("Enter", new Color(100, 149, 237), new Color(70, 130, 180));
            enterButton.addActionListener(e -> {
                chatClient.sendRoomSelection(room.getName());
                controller.showChatRoomWindow();
                chatClient.addWindow(controller.getChatRoomWindow());
            });
            roomEntry.add(enterButton, BorderLayout.EAST); // 添加按钮到右侧

            roomPanel.add(roomEntry);
            roomPanel.add(Box.createRigidArea(new Dimension(0, 10))); // 添加间隔
        }

        roomPanel.revalidate();
        roomPanel.repaint();
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

    private JButton createFlatButton(String text, Color bgColor, Color hoverColor) {
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



    public List<RoomInfo> getRoomInfos() {
        return roomInfos;
    }

    public void setRoomInfos(List<RoomInfo> roomInfos) {
        this.roomInfos = roomInfos;
        updateRoomListUI();
    }
// 定义其他必要的方法
}
