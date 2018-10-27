package com.demo.mydemo.cxf.server;

import javax.jws.WebService;

@WebService
public interface IHelloService {
    String sayX(String name);
}
