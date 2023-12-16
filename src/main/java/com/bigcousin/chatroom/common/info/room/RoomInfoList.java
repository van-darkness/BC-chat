package main.java.com.bigcousin.chatroom.common.info.room;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RoomInfoList implements Serializable {
    private ArrayList<RoomInfo> roomList;

    public RoomInfoList() {
        roomList = new ArrayList<>();
    }

    public void add(RoomInfo roomInfo) {
        roomList.add(roomInfo);
    }

    // 返回一个包含所有房间信息的列表的方法
    public List<RoomInfo> getRoomList() {
        return new ArrayList<>(roomList); // 返回列表的副本以保持封装性
    }
}
