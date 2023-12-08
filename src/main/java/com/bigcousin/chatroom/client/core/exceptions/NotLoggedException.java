package main.java.com.bigcousin.chatroom.client.core.exceptions;

public class NotLoggedException extends Exception{
    public NotLoggedException(){
        super();
        System.out.println("用户未登录");
    }
}
