package main.java.com.bigcousin.chatroom.common.info.room;

import java.io.Serializable;

public class RoomInfo implements Serializable {
    private int id;
    private String name;
    private int max_size;
    private int current_num;
    public RoomInfo(String name,int max_size,int id){
        this.max_size=max_size;
        this.name=name;
        this.id=id;
        current_num=0;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMax_size() {
        return max_size;
    }

    public int getCurrent_num() {
        return current_num;
    }

    @Override
    public String toString() {
        return "RoomInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", max_size=" + max_size +
                ", current_num=" + current_num +
                '}';
    }

    public void setCurrent_num(int size) {
        current_num=size;
    }
}