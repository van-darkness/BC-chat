package main.java.com.bigcousin.chatroom.common.message;

public class RoomSelectionMessage extends Message {
    private String roomName;

    public RoomSelectionMessage(String roomName) {
        super(MessageType.ROOM_SELECTION);
        this.roomName = roomName;
    }

    public String getRoomName() {
        return roomName;
    }
}
