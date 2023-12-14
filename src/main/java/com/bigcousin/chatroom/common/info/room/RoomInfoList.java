package main.java.com.bigcousin.chatroom.common.info.room;

import java.io.Serializable;
import java.util.ArrayList;

public class RoomInfoList implements Serializable {
    private ArrayList<RoomInfo> roomList;
    public RoomInfoList(){
        roomList=new ArrayList<>();

    }
    public void add(RoomInfo roomInfo){
        roomList.add(roomInfo);
    }
}
