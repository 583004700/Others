package com.demo;

import com.demo.cas.CasCounnter;
import org.java_websocket.WebSocketImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class Application
{
    static int k = 0;
    public static void main( String[] args )
    {
        //SpringApplication.run(Application.class, args);
        WebSocketImpl.DEBUG = false;
        int port = 8887; // 端口
        WsServer s = new WsServer(port);
        s.start();


        final AtomicInteger count = new AtomicInteger(0);
        final CasCounnter counter = new CasCounnter();

        for(int m=0;m<100;m++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        count.incrementAndGet();
                        Application.k++;
                        counter.increment();
                    }
                }
            });
            t.start();
        }


        try {
            Thread.sleep(2000);
        }catch (Exception e){

        }

        System.out.println(count.intValue());
        System.out.println(Application.k);
        System.out.println(counter.getValue());

    }
}
