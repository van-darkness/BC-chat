package main.java.com.bigcousin.chatroom.client.user;

// 用户状态接口
public interface UserStatus {
    void login();

    void chooseRoom(String roomName);

    void exitRoom(User user);

    void logout(User user);
}