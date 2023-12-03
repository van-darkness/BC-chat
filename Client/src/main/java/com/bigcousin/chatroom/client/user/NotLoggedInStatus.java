package main.java.com.bigcousin.chatroom.client.user;

import javax.security.auth.login.LoginContext;

import main.java.com.bigcousin.chatroom.client.messages.LogInMessage;
import main.java.com.bigcousin.chatroom.client.ui.LoginWindow;

public class NotLoggedInStatus extends UserCore implements UserStatus {
    public NotLoggedInStatus() {

    }

    // 未登录只需实现登陆操作
    @Override
    public void login() {
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
