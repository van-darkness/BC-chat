package main.java.com.bigcousin.chatroom.client.core;

import main.java.com.bigcousin.chatroom.data.user.UserInfo;

import java.net.Socket;

public class UserCore implements UserStatus {
    protected UserInfo userInfo;
    protected Socket socket;
    protected String serverAddress;
    protected int port;

    public UserCore() {

    }

    @Override
    public void login(String serverAddress, int port,UserStatus userStatus) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    @Override
    public void chooseRoom(String roomName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chooseRoom'");
    }

    @Override
    public void exitRoom(UserInfo userInfo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exitRoom'");
    }

    @Override
    public void logout(UserInfo userInfo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'logout'");
    }

    public UserInfo getUser() {
        return this.userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Socket getSocket() {
        return this.socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getServerAddress() {
        return this.serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
