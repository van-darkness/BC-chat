package core.userstates;

public class UnConnectedState implements UserState {

    @Override
    public void handleUserInput(String userInput) {
        // 在未连接状态下，用户输入可能会触发一些操作，例如显示提示信息
        System.out.println("Please connect to the server first.");
    }

    @Override
    public void handleServerResponse(String serverResponse) {
        // 在未连接状态下，接收到服务器响应可能需要处理，例如显示提示信息
        System.out.println("Received server response: " + serverResponse);
    }

    @Override
    public void login(String username, String password) {
        // 在未连接状态下，尝试登录可能需要先建立连接
        System.out.println("Connecting to the server...");
        // 实际操作可能包括建立连接的逻辑，这里只是演示
        // 建立连接后，可能切换状态为已连接状态 ConnectedState
    }

    @Override
    public void selectRoom(String roomName) {
        // 在未连接状态下，选择房间可能需要先建立连接
        System.out.println("Connecting to the server...");
        // 实际操作可能包括建立连接的逻辑，这里只是演示
        // 建立连接后，可能切换状态为已连接状态 ConnectedState
    }

    @Override
    public void logout() {
        // 在未连接状态下，注销可能不需要额外的操作
        System.out.println("You are not connected. No need to logout.");
    }

    @Override
    public void leaveRoom() {
        // 在未连接状态下，离开房间可能不需要额外的操作
        System.out.println("You are not connected to any room. No need to leave.");
    }

    @Override
    public void disconnect() {
        // 在未连接状态下，断开连接可能不需要额外的操作
        System.out.println("You are not connected. No need to disconnect.");
    }
}
