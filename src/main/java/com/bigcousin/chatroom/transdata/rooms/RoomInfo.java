package main.java.com.bigcousin.chatroom.transdata.rooms;

public class RoomInfo {
    private String name;
    private int id;
    private int max_size;

    public RoomInfo(String name, int id) {
        this.name = name;
        this.id = id;
        this.max_size=10;
    }
    public RoomInfo(String name, int id,int max_size) {
        this.name = name;
        this.id = id;
        this.max_size=max_size;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMax_size() {
        return max_size;
    }

    public void setMax_size(int max_size) {
        this.max_size = max_size;
    }
}
