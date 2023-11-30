package space;

import java.util.*;

public class Lobby {
    private List<Room> rooms;

    public Lobby() {
        this.rooms = new ArrayList<>();
    }

    // 添加房间到大厅
    public void addRoom(Room room) {
        rooms.add(room);
    }

    // 获取大厅内所有房间的名称
    public List<String> getAllRoomNames() {
        List<String> roomNames = new ArrayList<>();
        for (Room room : rooms) {
            roomNames.add(room.getName());
        }
        return roomNames;
    }

    // 获取指定房间
    public Room getRoomByName(String roomName) {
        for (Room room : rooms) {
            if (room.getName().equals(roomName)) {
                return room;
            }
        }
        return null; // 如果房间不存在，返回 null
    }

    // 在大厅中创建新房间
    public Room createRoom(String roomName) {
        Room newRoom = new Room(roomName);
        rooms.add(newRoom);
        return newRoom;
    }

    // 移除大厅中的房间
    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    // 启动大厅中所有房间的线程
    public void startAllRooms() {
        for (Room room : rooms) {
            new Thread(room).start();
        }
    }

}
