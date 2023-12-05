package main.java.com.bigcousin.chatroom.client.core;

import main.java.com.bigcousin.chatroom.client.ui.LoginWindow;
import main.java.com.bigcousin.chatroom.data.user.UserInfo;

public class NotLoggedInStatus extends UserCore{
    private UserStatus userCore;

    // 未登录状态只需实现登陆操作
    @Override
    public void login(String serverAddress, int port,UserStatus userCore) {
        this.port = port;
        LoginWindow loginWindow = new LoginWindow(this,userCore);

        // 先连接，后发送账号密码，等待服务器返回User类，然后转换状态
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

}
