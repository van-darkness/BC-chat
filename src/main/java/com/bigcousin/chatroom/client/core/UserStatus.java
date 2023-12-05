package main.java.com.bigcousin.chatroom.client.core;

import main.java.com.bigcousin.chatroom.data.user.UserInfo;

// 用户状态接口
public interface UserStatus {
    void login(String serverAddress, int port,UserStatus userCore);

    void chooseRoom(String roomName);

    void exitRoom(UserInfo userInfo);

    void logout(UserInfo userInfo);
}