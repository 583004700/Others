package simpleFactory;

public class Jian extends Operation {
    @Override
    public double getResult(double numberA,double numberB){
        double result = 0d;
        result = numberA-numberB;
        return result;
    }
}
