package com.demo.yunxi.reflection;

import org.reflections.Reflections;

import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception{
        Reflections reflections = new Reflections("com.demo.yunxi");
        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(Pay.class);
        for(Class<?> c : classSet){
            System.out.println("----"+c.getCanonicalName());
        }
    }
}
