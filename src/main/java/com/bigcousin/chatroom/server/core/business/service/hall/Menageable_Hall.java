package main.java.com.bigcousin.chatroom.server.core.business.service.hall;

import main.java.com.bigcousin.chatroom.data.messages.ChatMessage;
import main.java.com.bigcousin.chatroom.data.user.UserInfo;
import main.java.com.bigcousin.chatroom.server.core.business.service.user.User;

public interface Menageable_Hall {
    void addUser(User user);
    void kickUser(User user);
    void borderCast();
    void close();
    void senGroupChatMessage(ChatMessage chatMessage, UserInfo userInfo);//可通过工具方法直接将account转换为UserInfo
}
