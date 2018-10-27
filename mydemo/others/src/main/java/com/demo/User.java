package com.demo;

public class User {
    private String username;
    private String pwd;

    public User(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public static User getInstince(String username,String pwd){
        User user = new User();
        user.username = username;
        user.pwd = pwd;
        return user;
    }
}
