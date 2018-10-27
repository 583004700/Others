package interfaces;

public class Implement1 implements Interface1,Interface2 {
    @Override
    public void test1(){

    }

    int b = 20;

    @Override
    public void test(){}

    public void test2(int count){
        //Interface1.super.test1();
        System.out.println(a);

        //m被内部类引用，自动转为final类型，不能被重复赋值
        int m = 10;

        new Thread(new Runnable() {
            @Override
            public void run() {
                int c = m;
                int d = b;
            }
        });
    }

    public static void main(String[] args){
        Implement1 implement1 = new Implement1();
        implement1.test2(1);
    }
}
