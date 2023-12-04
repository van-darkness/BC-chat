package main.java.com.bigcousin.chatroom.data.user;

// 用户状态接口
public interface UserStatus {
    void login(String serverAddress, int port);

    void chooseRoom(String roomName);

    void exitRoom(User user);

    void logout(User user);
}