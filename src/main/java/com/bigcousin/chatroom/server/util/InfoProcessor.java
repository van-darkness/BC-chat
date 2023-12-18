package main.java.com.bigcousin.chatroom.server.util;

import main.java.com.bigcousin.chatroom.common.info.user.UserInfo;

import java.util.ArrayList;

public class InfoProcessor {
    public static boolean checkNickname(ArrayList<UserInfo> userInfos,String nickname){
        for(int i=0;i<userInfos.size();i++){
            if(nickname.equals(userInfos.get(i).getNickname()))return false;
        }
        return true;
    }
}
