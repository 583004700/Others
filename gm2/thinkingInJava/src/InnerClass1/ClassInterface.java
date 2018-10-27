package InnerClass1;

public interface ClassInterface {
    void howdy();
    class Test implements ClassInterface{
        public void howdy(){
            System.out.println("howdy!");
        }

        public static void main(String[] args){
            new Test().howdy();
        }
    }
}
