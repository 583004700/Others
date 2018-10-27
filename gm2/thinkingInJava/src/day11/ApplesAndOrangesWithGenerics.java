package day11;

import java.util.ArrayList;


public class ApplesAndOrangesWithGenerics {
    public static void main(String[] args){
        ArrayList<String> alstrs = new ArrayList<String>();
        alstrs.add("123");
        alstrs.add("abc");
        alstrs.add("中国");

        for(int i=0;i<alstrs.size();i++){
            System.out.println(alstrs.get(i));
        }
        System.out.println("================================");
        ArrayList<Apple> apples = new ArrayList<Apple>();
        for(int i=0;i<3;i++){
            apples.add(new Apple());
        }

        for(int i=0;i<apples.size();i++){
            System.out.println(apples.get(i).id());
        }

        System.out.println("******************************");
        for(Apple c : apples){
            System.out.println(c.id());
        }
    }
}
