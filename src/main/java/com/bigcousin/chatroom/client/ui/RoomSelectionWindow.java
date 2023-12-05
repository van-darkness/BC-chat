package main.java.com.bigcousin.chatroom.client.ui;

import main.java.com.bigcousin.chatroom.data.rooms.Room;
import main.java.com.bigcousin.chatroom.data.rooms.RoomInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomSelectionWindow extends JFrame {
    private DefaultListModel<Room> roomListModel;
    private JList<Room> roomList;

    public RoomSelectionWindow() {
        setTitle("Room Selection");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // 初始化房间列表模型
        roomListModel = new DefaultListModel<>();
        roomList = new JList<>(roomListModel);

        // 创建滚动窗格，以便在房间列表较多时可以滚动
        JScrollPane scrollPane = new JScrollPane(roomList);

        // 创建刷新按钮
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 在这里添加刷新房间列表的逻辑，可能需要调用服务器的方法获取最新的房间列表
                for(int i=0;i<roomList.getModel().getSize();i++){
                    roomListModel.remove(i);
                }
                //TODO:待完善刷新列表的逻辑

            }
        });

        // 创建进入房间按钮
        JButton enterRoomButton = new JButton("Enter Room");
        enterRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 在这里添加进入选定房间的逻辑
                Room selectedRoom = roomList.getSelectedValue();
                if (selectedRoom != null) {
                    // 进入选定房间的操作，可能需要打开新窗口等
                    System.out.println("Entering room: " + selectedRoom.getRoomInfo().getName());
                }
            }
        });

        // 布局
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(refreshButton);
        buttonPanel.add(enterRoomButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addRoom(Room room) {
        roomListModel.addElement(room);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RoomSelectionWindow roomSelectionWindow = new RoomSelectionWindow();
                roomSelectionWindow.setVisible(true);
                roomSelectionWindow.addRoom(Room.getRoom("D:\\Datas\\JavaProjects\\BC chat\\RoomDatas.txt",0));
                roomSelectionWindow.addRoom(Room.getRoom("D:\\Datas\\JavaProjects\\BC chat\\RoomDatas.txt",0));
                roomSelectionWindow.addRoom(Room.getRoom("D:\\Datas\\JavaProjects\\BC chat\\RoomDatas.txt",0));
                roomSelectionWindow.addRoom(Room.getRoom("D:\\Datas\\JavaProjects\\BC chat\\RoomDatas.txt",0));
                roomSelectionWindow.addRoom(Room.getRoom("D:\\Datas\\JavaProjects\\BC chat\\RoomDatas.txt",0));
                roomSelectionWindow.addRoom(Room.getRoom("D:\\Datas\\JavaProjects\\BC chat\\RoomDatas.txt",0));
            }
        });
    }
}
