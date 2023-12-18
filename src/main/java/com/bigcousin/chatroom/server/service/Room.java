package main.java.com.bigcousin.chatroom.server.service;

import main.java.com.bigcousin.chatroom.common.info.room.RoomInfo;
import main.java.com.bigcousin.chatroom.common.info.user.UserInfo;

import java.util.ArrayList;

public class Room {
    private RoomInfo roomInfo;
    private ArrayList<UserInfo> userInfos;

    public Room(RoomInfo roomInfo) {
        this.roomInfo = roomInfo;  // 将传入的 roomInfo 对象分配给成员变量
        userInfos = new ArrayList<>();
    }

    public void addUser(UserInfo userInfo) {
        userInfos.add(userInfo);
        roomInfo.setCurrent_num(userInfos.size()); // 更新当前房间人数
    }

    public void removeUser(UserInfo userInfo) {
        userInfos.remove(userInfo);
        roomInfo.setCurrent_num(userInfos.size()); // 更新当前房间人数
        // 后续添加广播消息的功能
    }

    public RoomInfo getRoomInfo() {
        return roomInfo;
    }

    public ArrayList<UserInfo> getUserInfos() {
        return userInfos;
    }

    // ... 其他方法 ...
}
