package simpleFactory;

public class Add extends Operation {
    @Override
    public double getResult(double numberA,double numberB){
        double result = 0d;
        result = numberA+numberB;
        return result;
    }
}
