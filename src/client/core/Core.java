package client.core;

public class Core {
    // Core类是客户端的内核，主要实现从用户系统输入流接受输入，对接服务端并接收信息，但不必显示信息
    // 显示信息的功能由GUI模块完成

    private ServerConnection serverConnection;

    // 构造方法，初始化时需要传入一个ServerConnection对象
    public Core(String serverAddress, int port) {
        this.serverConnection = new ServerConnection(serverAddress, port);

        // 在构造方法中建立连接，可以根据需要进行其他初始化操作
        if (serverConnection.isConnected()) {
            System.out.println("Connected to the server.");
        } else {
            System.out.println("Failed to connect to the server.");
        }
    }

    public void start() {

    }

    // 处理用户输入并发送到服务器的方法
    public void sendUserInput(String userInput) {
        // 验证和处理用户输入（如果需要的话）
        // 通过服务器连接将输入发送到服务器
        serverConnection.sendToServer(userInput);
    }

    // 从服务器接收信息的方法
    public void receiveFromServer() {
        // 通过服务器连接从服务器接收信息
        String serverResponse = serverConnection.receiveFromServer();

        // 处理服务器响应（例如，更新内部状态）
        processServerResponse(serverResponse);
    }

    // 处理服务器响应的方法（可以自定义）
    private void processServerResponse(String serverResponse) {
        // 在这里编写处理服务器响应的逻辑
        // 可能需要更新内部数据结构、触发事件等
    }

    // 其他核心功能的方法

    // ...

}
