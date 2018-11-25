package chuji.InnerClass;

public class DotThis {
    public int i;
    void f(){
        System.out.println("DotThis.f()");
    }

    public class Inner{
        public DotThis outer(){
            return DotThis.this;
        }
    }

    public Inner inner(){
        return new Inner();
    }
}

class Test{

    public static void main(String[] args){
        DotThis dt = new DotThis();
        dt.i = 10;
        DotThis.Inner inner = dt.inner();
        DotThis outer = inner.outer();
        System.out.println(outer.i);

    }
}