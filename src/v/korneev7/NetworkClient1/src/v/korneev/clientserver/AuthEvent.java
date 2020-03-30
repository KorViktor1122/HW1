package v.korneev.clientserver;

@FunctionalInterface

public interface AuthEvent {
    void authIsSuccessful(String nickname);
}
