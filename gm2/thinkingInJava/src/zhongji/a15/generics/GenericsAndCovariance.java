package zhongji.a15.generics;

import java.util.ArrayList;
import java.util.List;

class Fruit{}

class Apple extends Fruit{}

class Te<T extends Te<T>>{
    public void set(T t){}
}

class TeS2 extends Te{}

class TeS extends Te<TeS>{

}

public class GenericsAndCovariance {
    public static void main(String[] args) {
        //直接这样写会报错
        //List<Fruit> filst = new ArrayList<Apple>();

        List<? extends Fruit> flist = new ArrayList<Apple>();
        //也会报错
        //flist.add(new Apple());

        List<?> i = new ArrayList<Integer>();

        Te<TeS> te = new Te<TeS>();
    }
}
