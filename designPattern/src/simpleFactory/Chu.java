package simpleFactory;

public class Chu extends Operation {
    @Override
    public double getResult(double numberA,double numberB){
        double result = 0d;
        result = numberA/numberB;
        return result;
    }
}
