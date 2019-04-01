package com.demo.mydemo.cxf.client;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class Invoke {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
        bean.setAddress("http://localhost:8080/hihi");
        bean.setServiceClass(IHelloService.class);

        //添加日志拦截器
        bean.getOutInterceptors().add(new LoggingOutInterceptor());
        bean.getInInterceptors().add(new LoggingInInterceptor());
        bean.getOutInterceptors().add(new AuthInfoOutInterceptor());

        IHelloService helloService = (IHelloService)bean.create();
        System.out.println(helloService.sayX("小东西"));
    }
}
