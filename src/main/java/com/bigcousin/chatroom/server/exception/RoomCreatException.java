package main.java.com.bigcousin.chatroom.server.exception;

public class RoomCreatException extends Exception {
    public RoomCreatException(String roomName) {
        super("Failed to create room: " + roomName + " already exists.");
    }
}
