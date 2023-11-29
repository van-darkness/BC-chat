package test;

import client.core.Core;
import server.Server;

class Test {

    public static void main(String[] args) {
        int port = 8888;
        Server server = new Server(port);
        // server.start();
        Core clientCore = new Core("172.22.164.242", 8888);
    }
}