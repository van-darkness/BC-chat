package main.java.com.bigcousin.chatroom.client.ui;

import main.java.com.bigcousin.chatroom.client.controller.MainController;
import main.java.com.bigcousin.chatroom.client.core.ChatClient;
import main.java.com.bigcousin.chatroom.common.info.room.RoomInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RoomSelectionWindow extends JFrame {
    private MainController controller;
    private ChatClient chatClient;
    private JPanel roomPanel;

    public RoomSelectionWindow(MainController controller, ChatClient chatClient) {
        this.controller = controller;
        this.chatClient = chatClient;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Select a Room");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        roomPanel = new JPanel();
        roomPanel.setLayout(new BoxLayout(roomPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(roomPanel);
        add(scrollPane, BorderLayout.CENTER);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshRoomList();
            }
        });
        add(refreshButton, BorderLayout.SOUTH);

        //refreshRoomList(); // 初始时刷新房间列表
    }

    private void refreshRoomList() {
        chatClient.requestRoomInfosFromServer();
        roomPanel.removeAll();
        List<RoomInfo> rooms = chatClient.getRoomInfos(); // 获取房间信息列表

        for (RoomInfo room : rooms) {
            JPanel roomEntry = new JPanel(new FlowLayout());
            roomEntry.add(new JLabel(room.getName()));

            JButton enterButton = new JButton("Enter");
            enterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    chatClient.selectRoom(room.getName()); // 选择房间
                    controller.switchToChatRoomWindow(room.getName()); // 切换到聊天室窗口
                }
            });
            roomEntry.add(enterButton);
            roomPanel.add(roomEntry);
        }
        roomPanel.revalidate();
        roomPanel.repaint();
    }

    // 定义其他必要的方法
}
