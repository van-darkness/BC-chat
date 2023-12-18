package main.java.com.bigcousin.chatroom.common.info.user;

import main.java.com.bigcousin.chatroom.common.info.room.RoomInfo;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private String nickname;
    private int id;
    private RoomInfo roomInfo;//用于广播消息时遍历同房间的人以及其他相似用途
    public UserInfo(String name){
        this.nickname=name;
    }

    public UserInfo(String name,int id){
        this.nickname=name;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public RoomInfo getRoomInfo() {
        return roomInfo;
    }

    public void setRoomInfo(RoomInfo roomInfo) {
        this.roomInfo = roomInfo;
    }
}
