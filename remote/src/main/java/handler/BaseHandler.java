package handler;

public abstract class BaseHandler implements Handler{
    //完整的命令
    private String completeCommand;

    public BaseHandler(String completeCommand) {
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

}
