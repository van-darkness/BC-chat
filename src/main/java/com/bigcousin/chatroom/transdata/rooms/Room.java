package main.java.com.bigcousin.chatroom.transdata.rooms;

import main.java.com.bigcousin.chatroom.transdata.messages.ChatMessage;
import main.java.com.bigcousin.chatroom.server.core.business.service.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Room implements Runnable{
    private RoomInfo roomInfo;
    private ArrayList<User> userList;
    public Room(RoomInfo roomInfo){
        this.roomInfo=roomInfo;
        userList=new ArrayList<>(roomInfo.getMax_size());
    };
    public static Room getRoom(String dataPath, int id) {
        Room room = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(dataPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] roomInfoData = line.split("\t");
                if (roomInfoData.length == 3) {
                    int roomId = Integer.parseInt(roomInfoData[0]);
                    String roomName = roomInfoData[1];
                    int maxSize = Integer.parseInt(roomInfoData[2]);

                    // 如果找到匹配的房间ID，则创建 Room 对象
                    if (roomId == id) {
                        RoomInfo roomInfo = new RoomInfo(roomName, id,maxSize);
                        room = new Room(roomInfo); // 假设初始当前人数为0

                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return room;
    }


    public void addUser(User user){
        userList.add(user);
    }
    public static void CreatRoom(String dataPath,RoomInfo info){

    }
    private void sendChatMessageToUser(User user, ChatMessage message){

    }

    @Override
    public void run() {

    }

    public void setRoomInfo(RoomInfo roomInfo) {
        
    }

    public RoomInfo getRoomInfo() {
        return roomInfo;
    }
    public String toString() {
        return roomInfo.getName() + " (Max: " + roomInfo.getMax_size() + ", Current: " + userList.size() + ")";
    }
}
