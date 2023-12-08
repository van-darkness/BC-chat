package main.java.com.bigcousin.chatroom.client.core.business.service;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Community implements Closeable {
    private final Socket socket;
    private final InetAddress clientAddress;
    private final ObjectInputStream objectInputStream;
    private final ObjectOutputStream objectOutputStream;

    /**
     * 创建与服务器的通信连接
     *
     * @param serverAddress 服务器地址
     * @param port          服务器端口
     */
    public Community(String serverAddress, int port) {
        try {
            clientAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        try {
            socket = new Socket(serverAddress, port);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            objectInputStream = new ObjectInputStream(inputStream);
            objectOutputStream = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 发送对象到服务器
     *
     * @param object 要发送的对象
     */
    public void send(Object object) {
        try {
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 从服务器接收对象
     *
     * @return 从服务器接收的对象
     */
    public Object receive() {
        try {
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭与服务器的通信连接
     */
    @Override
    public void close() {
        try {
            socket.close();
            objectInputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public InetAddress getClientAddress() {
        return clientAddress;
    }
}
