package v.korneev.clientserver;

//import com.sun.xml.internal.ws.api.handler.MessageHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class NetworkService {

    private final String host;
    private final  int port;
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    private ClientController controller;

    private MessageHandler messageHandler;
    private AuthEvent successfulAuthEvent;
    private String nickname;

    public NetworkService(String host,int port){
        this.host = host;
        this.port = port;
    }

    public void connect(ClientController controller) throws IOException{
        this.controller = controller;
        socket = new Socket(host, port);
        in = new ObjectInputStream(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());
        runReadThread();
    }

    private void runReadThread(){
        new Thread(()-> {
            while (true){
                try {
                    Command command = (Command) in.readObject();
                    switch (Command.getType()) {
                        case AUTH: {
                            AuthCommand commandDate = (AuthCommand) command.getDta();
                            nickname = commandDate.getUsername();
                            successfulAuthEvent.authIsSuccessful(nickname);
                            break;
                        }
                        case MESSAGE: {
                            MessageCommand commandData = (MessageCommand) command.getDta();
                            if(messageHandler != null){
                                String message = commandData.getMaessage();
                                String username = commandData.getUsername();
                                if(username != null){
                                    message = username + " : " + message;
                                }
                                messageHandler.handle(message);
                            }
                            break;
                        }
                        case AUTH_ERROR:
                        case ERROR: {
                            ErrorCommand commandData = (ErrorCommand) command.getDta();
                            controller.showErrorMessage(commandData.getErrorMessage());
                            break;
                        }
                        case UPDATE_USERS_LIST: {
                            UpdateUsersListCommand commandDate = (UpdateUsersListCommand) command.getDta();
                            List<String> users = commandDate.getUsers();
                            controller.updateUsersList(users);
                            break;
                        }
                        default:
                            System.out.println(" Unknow type of command: " + Command.getType());
                    }
                } catch (IOException e) {
                    System.out.println(" Поток чтения был прерван! ");
                    return;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void sendCommand (Command command) throws IOException {
        out.writeObject(command);
    }

    public void setMessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    public void setSuccessfulAuthEvent(AuthEvent successfulAuthEvent){
        this.successfulAuthEvent = successfulAuthEvent;
    }
    public void close(){
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
