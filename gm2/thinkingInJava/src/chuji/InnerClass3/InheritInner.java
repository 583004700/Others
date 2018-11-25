package chuji.InnerClass3;

class WithInner{
    class Inner{
        public Inner(int i){

        }
    }
}

public class InheritInner extends WithInner.Inner{
    InheritInner(WithInner wi){
        wi.super(1);
    }

    public static void main(String[] args){
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);

    }
}
