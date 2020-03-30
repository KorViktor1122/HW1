package v.korneev.server;

//import sun.net.NetworkServer;
import v.korneev.clientserver.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler {

    private final NetworkServer networkServer;
    private final Socket clientSocket;

    private ObjectInputStream in;
    private ObjectOutputStream out;

    private String nickname;

    public ClientHandler(NetworkServer networkServer,Socket socket){
        this.networkServer = networkServer;
        this.clientSocket = socket;
    }

    public void  run(){
        doHandle(clientSocket);
        }

        private void doHandle(Socket socket){
        try{
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            new Thread(() ->{
                try{
                    authentication();
                    readMessages();
                } catch (IOException e){
                    System.out.println("Соединеие с кклиентом " + nickname + " было закрыто! ");
                } finally {
                    closeConnection();
                }
            }).start();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private void closeConnection(){
        try {
            networkServer.unsubscribe(this);
            clientSocket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void readMessages() throws IOException {
        while (true){
            Command command = readCommand();
            if( command == null){
                continue;
            }
            switch (command.getType()){
                case END:
                    System.out.println("Received 'END' command");
                    return;
                case PRIVATE_MESSAGE:{
                    PrivateMessageCommand commandData = (PrivateMessageCommand)command.getDta();
                    String receiver = commandData.getRecevier();
                    String message = commandData.getMessage();
                    networkServer.sendMessage(receiver, Command.messageCommand(nickname,message));
                    return;
                }
                case BROADCAST_MESSAGE:{
                    BroadcastMessageCommand commandData = (BroadcastMessageCommand)command.getDta();
                    String message = commandData.getMessage();
                    networkServer.broadcastMessage(Command.messageCommand(nickname,message),this);
                    break;
                }
                default:
                    System.out.println("Unkhow type of command : " + command.getType());
            }
        }
    }

    private Command readCommand() throws IOException {
        try{
            return (Command) in.readObject();
        } catch (ClassNotFoundException e) {
            String errorMessage = "Unkhow type of object from client! ";
            System.err.println(errorMessage);
            e.printStackTrace();
            sendMessage(Command.errorCommand(errorMessage));
            return null;
        }
    }

    private void authentication() throws IOException{
        while (true){
            Command command = readCommand();
            if(command == null){
                continue;
            }
            if(command.getType() == CommandType.AUTH) {
                boolean successfuiAuth = processAuthCommand(command);
                if (successfuiAuth) {
                    return;
                }
            } else {
                    System.err.println("Unknow type of command for auth process :" + command.getType());
                }
            }
        }

        private boolean processAuthCommand(Command command) throws IOException{
            AuthCommand commandData = (AuthCommand) command.getDta();
            String login = commandData.getLogin();
            String password = commandData.getPassword();
            String username = networkServer.getAuthService().getUsernameByLoginAndPassword(login,password);
            if( username == null){
                Command authErrorCommand = Command.authErrorCommand("Отсутствует учётная запись по данному логину и паролю!");
                sendMessage(authErrorCommand);
                return false;
            }
            else if (networkServer.isNicknameBusy(username)){
                Command authErrorCommand = Command.authErrorCommand("Данный пользователь уже авторизован!");
                sendMessage(authErrorCommand);
                return false;
            }
            else {
                nickname = username;
                String message = nickname + " зашёл ы чат! ";
                networkServer.broadcastMessage(Command.messageCommand(null, message), this);
                commandData.setUsername(nickname);
                sendMessage(command);
                networkServer.subscribe(this);
                return true;
            }
        }
        public void sendMessage(Command command) throws IOException{
        out.writeObject(command);
        }

        public String getNickname(){
        return nickname;
        }

    }


