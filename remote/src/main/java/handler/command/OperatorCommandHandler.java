package handler.command;

import java.io.PrintWriter;

public abstract class OperatorCommandHandler extends CommandHandler {
    private String otherKey;

    public OperatorCommandHandler(String otherKey, String completeCommand, PrintWriter printWriter) {
        super(completeCommand,printWriter);
        this.otherKey = otherKey;
    }

    public String getOtherKey() {
        return otherKey;
    }

    public void setOtherKey(String otherKey) {
        this.otherKey = otherKey;
    }
}
