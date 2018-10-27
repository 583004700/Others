package simpleFactory;

public class OperationFactory {
    public static Operation createOperation(String operate){
        Operation operation;
        switch (operate){
            case "+":
                operation = new Add();
                break;
            case "-":
                operation = new Jian();
                break;
            case "*":
                operation = new Cheng();
                break;
            case "/":
                operation = new Chu();
                break;
            default:
                operation = new Add();
        }
        return operation;
    }
}
