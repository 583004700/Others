package interfaces;

//如果接口中只有一个抽象方法，该接口默认为函数式接口，也可以使用注解@FunctionalInterface指明该接口为函数式接口
@FunctionalInterface
public interface Interface1 {

    static int a = 10;

    /**
     * 静态方法不会被实现类继承
     */
    static void staticMethod(){
        System.out.println("Interface1.staticMethod()");
    }

    default void test1(){
        System.out.println("Interface1.test()");
        new Thread( () -> System.out.println("lambda") ).start();
    }

    void test();
}
