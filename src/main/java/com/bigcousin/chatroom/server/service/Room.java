package main.java.com.bigcousin.chatroom.server.service;

import main.java.com.bigcousin.chatroom.common.info.room.RoomInfo;
import main.java.com.bigcousin.chatroom.common.info.user.UserInfo;

import java.util.ArrayList;

public class Room {
    //后续可能需要使用接口来规范房间的用户管理的方法
    private RoomInfo roomInfo;
    private ArrayList<UserInfo> userInfos;
    public Room(RoomInfo roomInfo){
        userInfos=new ArrayList<>();
    }
    public void addUser(UserInfo userInfo){
        userInfos.add(userInfo);
    }
    public void removeUser(UserInfo userInfo){
        userInfos.remove(userInfo);
        //后续添加广播消息的功能
    }

    public RoomInfo getRoomInfo() {
        return roomInfo;
    }

    public ArrayList<UserInfo> getUserInfos() {
        return userInfos;
    }

}
