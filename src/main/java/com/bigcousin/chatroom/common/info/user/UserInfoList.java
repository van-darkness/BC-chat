package main.java.com.bigcousin.chatroom.common.info.user;

import java.io.Serializable;
import java.util.ArrayList;

public class UserInfoList implements Serializable {
    private ArrayList<UserInfo> userInfoArrayList;
    public UserInfoList(){
        userInfoArrayList =new ArrayList<>();
    }
    public void add(UserInfo userInfo){
        userInfoArrayList.add(userInfo);
    }
}
