package zhongji.a14.typeinfo;

class Base{

}

class Derived extends Base{

}

public class FamilyVsExactType {
    public static void main(String[] args) {
        //test(new Base());
        test(new Derived());
    }

    public static void test(Object x){
        System.out.println(x.getClass());
        System.out.println("x instanceof Base"+(x instanceof Base));
        System.out.println("x instanceof Derived"+(x instanceof Derived));

        System.out.println("Base.class.isInstance(x)"+(Base.class.isInstance(x)));
        System.out.println("Derived.class.isInstance(x)"+(Derived.class.isInstance(x)));

        System.out.println("Base.class == (x)"+(Base.class == (x.getClass())));
        System.out.println("Derived.class == (x)"+(Derived.class == (x.getClass())));
    }
}
