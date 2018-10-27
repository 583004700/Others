package com.ry.xk.main.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTest {
    @Async
    public void say()
    {
        for (int i = 0; i < 10000; i++ )
        {
            System.out.println("异步");
        }
    }
}
