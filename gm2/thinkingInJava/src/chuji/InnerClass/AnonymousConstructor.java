package chuji.InnerClass;

abstract class Base{
    public Base(int i){
        System.out.println("Base"+i);
    }
    public abstract void f();
}

public class AnonymousConstructor {
    public static Base getBase(int i){
        return new Base(i) {
            {System.out.println("实例内部初始化");}
            @Override
            public void f() {
                System.out.println("执行匿名子类f方法");
            }
        };
    }

    public static void main(String[] args){
        Base b = getBase(10);
        b.f();
    }
}
