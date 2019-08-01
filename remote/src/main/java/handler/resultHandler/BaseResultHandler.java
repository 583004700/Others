package handler.resultHandler;

import command.entity.OperatorComputer;

public class BaseResultHandler {
    private OperatorComputer operatorComputer;
    private String result;

    public BaseResultHandler(OperatorComputer operatorComputer, String result) {
        this.operatorComputer = operatorComputer;
        this.result = result;
    }

    public OperatorComputer getOperatorComputer() {
        return operatorComputer;
    }

    public void setOperatorComputer(OperatorComputer operatorComputer) {
        this.operatorComputer = operatorComputer;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
