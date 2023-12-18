package main.java.com.bigcousin.chatroom.common.info.user;

import main.java.com.bigcousin.chatroom.common.info.room.RoomInfo;

import java.io.Serializable;
import java.awt.*;
import java.util.Random;

public class UserInfo implements Serializable {
    private String nickname;
    private int id;
    private Color color;
    private RoomInfo roomInfo;//用于广播消息时遍历同房间的人以及其他相似用途
    public UserInfo(String name){
        this.nickname=name;
    }

    public UserInfo(String name,int id){
        this.nickname=name;
        this.id=id;
        this.color=getUserColor(id);
    }
    private Color getUserColor(int userId) {
        Random rand = new Random(userId); // 使用用户ID作为随机种子
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r, g, b);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        this.color=getUserColor(id);
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

    public Color getColor() {
        return color;
    }
}
