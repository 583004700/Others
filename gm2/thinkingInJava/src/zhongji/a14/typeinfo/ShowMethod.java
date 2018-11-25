package zhongji.a14.typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethod {
    private static Pattern p = Pattern.compile("\\w+\\.");
    public static void main(String[] args) {
        Class<?> c = ShowMethod.class;
        Method[] methods = c.getMethods();
        Constructor[] constructors = c.getConstructors();
        for(Method m: methods){
            System.out.println(m.toString());
        }
        for(Constructor co:constructors){
            System.out.println(co.toString());
        }

        Student s1 = Student.getInstance();

        Field[] fields = Student.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                System.out.println(fields[i].get(s1));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println(fields[i].getName());
        }
    }
}
