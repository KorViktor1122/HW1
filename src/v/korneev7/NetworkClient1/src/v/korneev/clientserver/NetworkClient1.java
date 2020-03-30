package v.korneev.clientserver;

import java.io.IOException;

public class NetworkClient1 {
    public static void main(String[] args) {
        try {
            ClientController clientController = new  ClientController("localhost", 8189);
            clientController.runApplication();
        } catch (IOException e) {
            System.out.println(" Failed to connect to server! Please, check you network settings.");
        }
    }
}
