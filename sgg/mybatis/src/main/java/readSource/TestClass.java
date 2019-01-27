package readSource;

public class TestClass {
    public static void main(String[] args) {
        System.out.println(TestClass.class.toString());
        System.out.println(new TestClass().getClass() == TestClass.class);
    }
}
