package server.service;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private final int PORT = 12345;
    private Set<PrintWriter> writers = Collections.synchronizedSet(new HashSet<>());
    private InetAddress serverAddress;

    public ChatServer() throws Exception {
        System.out.println("Chat Server is running...");
        ServerSocket listener = new ServerSocket(PORT);
        serverAddress = InetAddress.getLocalHost();
        System.out.println("ServerAddress:" + serverAddress.getHostAddress());
        try {
            while (true) {
                new ClientHandler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }

}
