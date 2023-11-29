package client.core.userstates;

public interface UserState {
    void handleUserInput(String userInput);

    void handleServerResponse(String serverResponse);

    void login(String username, String password);

    void selectRoom(String roomName);

    void logout();

    void leaveRoom();

    void disconnect();
}
