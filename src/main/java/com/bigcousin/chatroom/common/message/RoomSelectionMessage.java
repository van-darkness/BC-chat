package main.java.com.bigcousin.chatroom.common.message;

import main.java.com.bigcousin.chatroom.common.info.user.UserInfo;

public class RoomSelectionMessage extends Message {
    private String roomName;
    private UserInfo userInfo;
    private boolean isSwitch;//使用一个布尔类型来区分初次选择房间与切换房间
    public RoomSelectionMessage(String roomName,UserInfo userInfo) {
        super(MessageType.ROOM_SELECTION);
        this.roomName = roomName;
        this.userInfo=userInfo;
        this.isSwitch=false;
    }
    public RoomSelectionMessage(String roomName,UserInfo userInfo,boolean isSwitch) {
        super(MessageType.ROOM_SELECTION);
        this.roomName = roomName;
        this.userInfo=userInfo;
        this.isSwitch=isSwitch;

    }
    public String getRoomName() {
        return roomName;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public boolean isSwitch() {
        return isSwitch;
    }
}
