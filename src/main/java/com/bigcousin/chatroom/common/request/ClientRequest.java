package main.java.com.bigcousin.chatroom.common.request;

import main.java.com.bigcousin.chatroom.common.info.user.UserInfo;

import java.io.Serializable;

public class ClientRequest implements Serializable {
    //先将Request设计成基类，未来可以有更多子类
    //beta阶段可以直接使用Request作为基类
    private UserInfo userInfo;
    private ClientRequestType clientRequestTypel;
    public ClientRequest(UserInfo userInfo, ClientRequestType clientRequestTypel) {
        this.userInfo = userInfo;
        this.clientRequestTypel = clientRequestTypel;
    }
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public ClientRequestType getRequestTypel() {
        return clientRequestTypel;
    }
}
