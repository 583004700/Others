package executor;

public class BaseExecutor {
    private String completeCommand;
    private String separator = ":";

    public BaseExecutor(String completeCommand) {
        this.completeCommand = completeCommand;
    }

    public String getPrefix(){
        if(!completeCommand.contains(separator)){
            return "";
        }
        String prefix = completeCommand.substring(0,completeCommand.indexOf(separator));
        return prefix;
    }

    public String getCommand(){
        if(!completeCommand.contains(separator)){
            return "";
        }
        String command = completeCommand.substring(completeCommand.indexOf(separator)+1,completeCommand.length());
        return command;
    }

    public String getCompleteCommand() {
        return completeCommand;
    }

    public void setCompleteCommand(String completeCommand) {
        this.completeCommand = completeCommand;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }
}
