package main.java.com.bigcousin.chatroom.server.util;

import main.java.com.bigcousin.chatroom.data.messages.LogInMessage;
import main.java.com.bigcousin.chatroom.data.user.UserInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MessageProcessor {
    public  static UserInfo findUserByLogInMessage(String filePath, LogInMessage logInMessage) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userInfo = line.split("\t");
                if (userInfo.length == 4) {
                    String role = userInfo[0];
                    String nickname = userInfo[1];
                    String account = userInfo[2];
                    String password = userInfo[3];

                    // 检查账号和密码是否匹配
                    if (account.equals(logInMessage.getAcount()) && password.equals(logInMessage.getPassword())) {
                        return new UserInfo(nickname, account, password, role);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // 返回 null 表示未找到匹配的用户信息
    }
    public static UserInfo accountToUserInfo(String account, ArrayList<UserInfo> userInfoArrayList) {
        for (UserInfo userInfo : userInfoArrayList) {
            if (userInfo.getAccount().equals(account)) {
                return userInfo;
            }
        }
        return null; // 如果找不到对应账号的用户信息，返回null或者抛出异常，具体根据业务需求来定
    }


}
