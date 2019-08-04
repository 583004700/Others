package handler.resultHandler;

import command.entity.Operator;

public class BaseResultHandler {
    private Operator operator;
    private String result;

    public BaseResultHandler(Operator operator, String result) {
        this.operator = operator;
        this.result = result;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
