package com.demo.parseTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Integer,Persion1> m = new HashMap<Integer, Persion1>();
    public static void main(String[] args){
        List<Person> list = new ArrayList<Person>();
        Person p1 = new Person(1,"张三",0,"");
        Person p2 = new Person(2,"李四",1,"张三");
        Person p3 = new Person(3,"王五",2,"李四");
        Person p4 = new Person(4,"4",0,"");
        Person p5 = new Person(5,"5",4,"4");
        Person p6 = new Person(6,"6",5,"5");
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        List<Persion1> tree = new ArrayList<Persion1>();
        parse(list,tree);
        System.out.println("");
    }

    public static void parse(List<Person> list,List<Persion1> tree){
        for(int i=0;i<list.size();i++){
            Person p = list.get(i);
            if(p.getPid() == 0){
                Persion1 persion1 = new Persion1(p.getId(),p.getName());
                tree.add(persion1);
                m.put(persion1.getId(),persion1);
            }else{
                Persion1 persion1 = new Persion1(p.getId(),p.getName());
                m.get(p.getPid()).getSubs().add(persion1);
                m.put(p.getId(),persion1);
            }
        }
    }
}
