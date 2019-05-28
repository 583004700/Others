package readSource;

import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ResolvableTypeTest<T> extends ArrayList<String> {
    // GenericArrayType：组件类型为类型变量的数组
    public T[] a;
    // GenericArrayType：组件类型为参数化类型的数组
    public List<?>[] b;
    // ParameterizedType：参数化类型
    // List<? extends Object>携带的"? extends Object"
    // 即通配符表达式，也就是WildcardType
    public List<? extends Object> c;
    // Class：普通类型
    public List d;
    // 类型变量 TypeVariable
    public T e;

    int[] arr;

    public static void main(String[] args) throws Exception{
        Class c = int[].class;
        Class i = Integer[].class;
        System.out.println(c.getComponentType());
        System.out.println(i.getComponentType());

        ResolvableType type = ResolvableType.forClass(ResolvableTypeTest.class);
        System.out.println(type.getSuperType());

        System.out.println(type.resolve());

        System.out.println(type.as(List.class));

        System.out.println(type.getGeneric(0).getType() == type.resolveGeneric(0));
        System.out.println(type.getGeneric(0));

        Field field = ResolvableTypeTest.class.getDeclaredField("arr");
        ResolvableType r = ResolvableType.forField(field);
        System.out.println(r.getComponentType().getType() == int.class);


        System.out.println(ResolvableTypeTest.class.getAnnotation(Controller.class));
    }
}
