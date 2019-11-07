package com.atguigu.shiro.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;

public class ShiroRealm extends AuthenticatingRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("doGetAuthenticationInfo:"+token);
        System.out.println("2.token:"+token.hashCode());
        //将AuthenticationToken转换为UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        if("unknown".equals(username)){
            throw new UnknownAccountException("用户名不存在");
        }
        if("monster".equals(username)){
            throw new LockedAccountException("用户被锁定");
        }
        //以下信息是从数据库中获取出来的
        //principal可以是用户名，也可以是用户对象
        //credentials数据表中获取的密码
        //realmName 当前对象realm的name，调用父类对象的getName()方法即可
        Object principal = username;
        Object credentials = "123456";
        String realmName = super.getName();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,credentials,realmName);
        return info;
    }
}
