package readSource;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class TestType<E> extends ArrayList<Integer> {

    public List<Integer> r(){
        return new ArrayList<Integer>();
    }

    public static void main(String[] args) throws Exception{
        TestType<Integer> testType1 = new TestType<Integer>();
        Class cls1 = testType1.getClass();
        System.out.println(cls1);
        System.out.println(cls1.getGenericSuperclass());
        System.out.println(((ParameterizedType)cls1.getGenericSuperclass()).getActualTypeArguments()[0]);
        System.out.println(((ParameterizedType)cls1.getGenericSuperclass()).getRawType());
        System.out.println(cls1.getDeclaredMethod("r").getReturnType());
        System.out.println(cls1.getDeclaredMethod("r").getGenericReturnType());
        System.out.println(cls1.getMethods().length);
        System.out.println(cls1.getDeclaredMethods().length);
    }
}
