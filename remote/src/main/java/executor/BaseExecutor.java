package executor;

import command.entity.Computer;
import handler.BaseHandler;

public class BaseExecutor extends BaseHandler {
    private Computer computer;

    @Override
    public Object handler() {
        return null;
    }

    public BaseExecutor(String completeCommand, Computer computer) {
        super(completeCommand);
        this.computer = computer;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
