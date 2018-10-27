package interfaces;

public interface Interface2 {

    static void staticMethod(){
        System.out.println("Interface2.staticMethod()");
    }

    default void test1(){
        System.out.println("Interface2.test()");
    }
}
