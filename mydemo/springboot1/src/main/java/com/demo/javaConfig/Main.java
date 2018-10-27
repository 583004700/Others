package com.demo.javaConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
        UserService userService = context.getBean(UserService.class);
        List<User> users = userService.queryUserList();
        users.forEach((o)->System.out.println(o.getUsername()));
        System.out.println("--------"+context.getBean(DataSource.class).getConnection());
        context.destroy();
    }
}
