
package chuji.MethodIn;

public class Main {
    public static void main(String[] args){
        MethonIn m = new MethonIn();
        MethonIn m2 = new MethonIn();
    }
}

class MethonIn{

    static {
        //静态代码块只会执行一次
        System.out.println("静态代码块被调用");
    }

    int k;

    {
        //实例化语句块每次创建对象都被执行
        k = 5;
        System.out.println("k=5");
    }

    static void m(){
        System.out.println("静态方法M被调用");
    }

    public int g = g();

    public MethonIn(){
        System.out.println("构造方法被调用");
    }

    public int g(){
        System.out.println("g被调用");
        return 11;
    }
}
