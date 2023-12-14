package main.java.com.bigcousin.chatroom.common.message;

import main.java.com.bigcousin.chatroom.common.info.user.UserInfo;

public class RoomSelectionMessage extends Message {
    private String roomName;
    private UserInfo userInfo;
    public RoomSelectionMessage(String roomName,UserInfo userInfo) {
        super(MessageType.ROOM_SELECTION);
        this.roomName = roomName;
        this.userInfo=userInfo;
    }

    public String getRoomName() {
        return roomName;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
}
