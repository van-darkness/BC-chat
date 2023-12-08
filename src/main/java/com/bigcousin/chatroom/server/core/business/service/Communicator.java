package main.java.com.bigcousin.chatroom.server.core.business.service;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Communicator extends Thread{
    private InetAddress serverAddress;
    private  ServerSocket serverSocket;
    private final Socket socket;
    private final ObjectInputStream objectInputStream;
    private final ObjectOutputStream objectOutputStream;
    public Communicator(ServerSocket serverSocket){
        try {
            this.serverSocket=serverSocket;
            socket=serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            objectInputStream = new ObjectInputStream(inputStream);
            objectOutputStream = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void send(Object object) {

    }
    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    @Override
    public void run() {
        super.run();

    }
}
