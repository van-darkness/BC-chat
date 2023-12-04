package main.java.com.bigcousin.chatroom.data.user;

import main.java.com.bigcousin.chatroom.client.ui.LoginWindow;

public class NotLoggedInStatus extends UserCore implements UserStatus {

    // 未登录只需实现登陆操作
    @Override
    public void login(String serverAddress, int port) {
        this.port = port;
        LoginWindow loginWindow = new LoginWindow(this);
        // 先连接，后发送账号密码，等待服务器返回User类，然后转换状态

    }

    @Override
    public void chooseRoom(String roomName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chooseRoom'");
    }

    @Override
    public void exitRoom(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exitRoom'");
    }

    @Override
    public void logout(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'logout'");
    }

}
