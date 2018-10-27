package com.demo.javaConfig;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public List<User> queryUserList(){
        List<User> result = new ArrayList<User>();
        for(int i=0;i<10;i++){
            User user = new User();
            user.setUsername("username_"+i);
            user.setPassword("password_"+i);
            user.setAge(i);
            result.add(user);
        }
        return result;
    }
}
