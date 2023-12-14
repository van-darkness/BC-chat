package main.java.com.bigcousin.chatroom.server.exception;

import main.java.com.bigcousin.chatroom.common.info.user.UserInfo;

public class NullMessageException extends Exception{
    public NullMessageException(UserInfo userInfo){
        //后续将异常信息显示到服务器系统日志
        System.out.println(userInfo.getId()+"的消息为空:");
    }
}
