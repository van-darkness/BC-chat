package client;

import client.core.Core;

public class ClientAPP {
    public static void main(String[] args) {
        Core clientCore = new Core("172.22.164.242", 8888);
    }
}