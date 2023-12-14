package main.java.com.bigcousin.chatroom.common.info.room;

import java.io.Serializable;

public class RoomInfo implements Serializable {
    public int id;
    public String name;
    private int max_size;
    private int current_num;
    public RoomInfo(String name,int max_size,int id){
        this.max_size=max_size;
        this.name=name;

        current_num=0;
    }
}