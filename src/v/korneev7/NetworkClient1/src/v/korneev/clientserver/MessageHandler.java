package v.korneev.clientserver;

@FunctionalInterface

public interface MessageHandler {
    void handle(String message);
}

