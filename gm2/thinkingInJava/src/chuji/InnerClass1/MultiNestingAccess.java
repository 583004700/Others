package chuji.InnerClass1;

class MNA{
    private void f(){}
    class A{
        private void g(){}
        public class B{
            void h(){
                g();
                f();
                A a = new A();
                B b = new B();
                //引用外部对象
                A a1 = A.this;
            }
        }
    }

    class B{}
}

public class MultiNestingAccess {
    public static void main(String[] args){
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();

        //非静态内部类必须通过外部类的对象创建
        //MNA.A mnaa1 = new MNA.A();
    }
}
