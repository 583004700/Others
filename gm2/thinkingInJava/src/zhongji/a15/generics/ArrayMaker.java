package zhongji.a15.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMaker<T> {
    private Class<T> kind;
    private ArrayMaker(Class<T> kind){
        this.kind = kind;
    }

    T[] create(int size){
        //创建长度为size的kind类型的数组
        return (T[]) Array.newInstance(kind,size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringArrayMaker = new ArrayMaker<String>(String.class);
        String[] stringArray = stringArrayMaker.create(9);
        System.out.println(Arrays.asList(stringArray));
    }
}
