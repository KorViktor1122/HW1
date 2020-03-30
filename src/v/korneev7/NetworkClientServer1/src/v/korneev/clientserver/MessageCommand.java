package v.korneev.clientserver;

import java.io.Serializable;

public class MessageCommand implements Serializable {

    private final String username;
    private final String maessage;

    public MessageCommand(String username, String maessage){
        this.username = username;
        this.maessage = maessage;

    }

    public String getUsername() {
        return username;
    }

    public String getMaessage() {
        return maessage;
    }
}
