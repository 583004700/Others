package com.demo.mydemo.cxf.server;

import javax.jws.WebService;

@WebService(endpointInterface = "com.demo.mydemo.cxf.server.IHelloService")
public class HelloServiceImpl implements IHelloService{
    @Override
    public String sayX(String name) {
        return name+"say 小奶瓶！";
    }
}
