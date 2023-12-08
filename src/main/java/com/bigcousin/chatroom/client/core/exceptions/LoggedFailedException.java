package main.java.com.bigcousin.chatroom.client.core.exceptions;

public class LoggedFailedException extends Exception{
    public LoggedFailedException(){
        super();
        System.out.println("登陆失败!");
    }
}
