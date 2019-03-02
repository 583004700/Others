package executor;

public class BaseExecutor {
    public static final String SEPARATOR = ":";
    public static String getPrefix(String completeCommand){
        if(!completeCommand.contains(":")){
            return "";
        }
        String prefix = completeCommand.substring(0,completeCommand.indexOf(SEPARATOR));
        return prefix;
    }

    public static String getCommand(String completeCommand){
        if(!completeCommand.contains(":")){
            return "";
        }
        String command = completeCommand.substring(completeCommand.indexOf(SEPARATOR)+1,completeCommand.length());
        return command;
    }
}
