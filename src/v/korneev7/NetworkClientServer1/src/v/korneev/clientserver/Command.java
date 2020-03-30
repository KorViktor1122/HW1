package v.korneev.clientserver;

import java.io.Serializable;
import java.util.List;

public class Command implements Serializable {
    private static CommandType type;
   // private CommandType type;
    private Object data;

    public Object getDta(){
        return data;
    }

    public static CommandType getType(){
        return type;
    }

    public static Command authCommand (String login, String password){
        Command command = new Command();
        type = CommandType.AUTH;
        command.data = new AuthCommand(login, password);
        return command;
    }

    public static Command authErrorCommand(String errorMessage){
         Command command = new Command();
         type = CommandType.AUTH_ERROR;
         command.data = new ErrorCommand(errorMessage);
         return command;
     }
    public static Command errorCommand(String errorMessage){
        Command command = new Command();
        type = CommandType.ERROR;
        command.data = new  ErrorCommand(errorMessage);
        return command;
    }
    public static Command messageCommand(String username, String message){
        Command command = new Command();
        type = CommandType.MESSAGE;
        command.data = new MessageCommand(username,message);
        return command;
    }

    public static Command broadcastMessageCommand(String message){
        Command command = new Command();
        type = CommandType.BROADCAST_MESSAGE;
        command.data = new BroadcastMessageCommand(message);
        return command;
    }

    public static Command privateMessageCommand(String receiver, String message){
        Command command = new Command();
        type = CommandType.PRIVATE_MESSAGE;
        command.data = new PrivateMessageCommand(receiver,message);
        return command;
    }
    public static Command updateUsersListCommand(List<String> users){
        Command command = new Command();
        type = CommandType.UPDATE_USERS_LIST;
        command.data = new UpdateUsersListCommand(users);
        return command;
    }

    public static Command endCommand(){
        Command command = new Command();
        type = CommandType.END;
        return command;
    }
}
