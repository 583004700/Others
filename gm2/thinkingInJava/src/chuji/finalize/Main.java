package chuji.finalize;

public class Main {
    public static void main(String[] args){
        Main m = new Main();
        m.test();
        System.gc();
    }

    public void test(){
        new ClassA("a");
    }
}


class ClassA{
    String name;
    ClassA(String name){
        this.name = name;
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.name + "被回收");
        super.finalize();
    }
}