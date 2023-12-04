package main.java.com.bigcousin.chatroom.data.user;

public class NotInRoomStatus extends UserCore implements UserStatus {

    @Override
    public void login(String serverAddress, int port) {
        super.serverAddress = serverAddress;
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'login'");
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
