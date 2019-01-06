package readSource;

public class TestType<E> {
    public static void main(String[] args) {
        TestType<Integer> testType1 = new TestType<Integer>();
        Class cls1 = testType1.getClass().getComponentType();
        System.out.println(cls1);
    }
}
