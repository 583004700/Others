package executor;

import command.entity.Computer;

public class BaseExecutor {
    private String completeCommand;
    private String separator = ":";
    private Computer computer;

    public BaseExecutor(String completeCommand,Computer computer) {
        this.completeCommand = completeCommand;
        this.computer = computer;
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

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
