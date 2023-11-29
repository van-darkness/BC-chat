package client;

import client.core.Core;
import data.user.User;

public class Client {

    public Client() {
        Core clientCore = new Core("172.22.164.242", 8888);
    }

}