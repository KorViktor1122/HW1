package v.korneev.clientserver;

import java.io.Serializable;

public class PrivateMessageCommand implements Serializable {
    private final String recevier;
    private final String message;

    public PrivateMessageCommand(String recevier, String message){
        this.recevier = recevier;
        this.message = message;
    }

    public String getRecevier() {
        return recevier;
    }

    public String getMessage() {
        return message;
    }
}
