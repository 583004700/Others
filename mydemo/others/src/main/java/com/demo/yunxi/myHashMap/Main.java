package com.demo.yunxi.myHashMap;

public class Main {
    public static void main(String[] args){
        User user1 = new User(new String("张三"));
        User user2 = new User(new String("张三"));
        System.out.println(user1.name == user2.name);
        System.out.println(user1.name.equals(user2.name));
        System.out.println(user1.name.hashCode() == user2.name.hashCode());
    }
}
