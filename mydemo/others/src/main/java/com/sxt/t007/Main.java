package com.sxt.t007;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        LongEventFactory factory = new LongEventFactory();
        int ringBufferSize = 1024 * 1024;

        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(factory,ringBufferSize,executor,
                ProducerType.SINGLE,new YieldingWaitStrategy());
        disruptor.handleEventsWith(new LongEventHandler());
        disruptor.handleEventsWith(new LongEventHandler());
        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        LongEventProducer producer = new LongEventProducer(ringBuffer);
        //ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        for(long l=0;l<10000;l++){
            //byteBuffer.putLong(0,l);
            //producer.onData(byteBuffer);
            producer.onData(l);
        }

        disruptor.shutdown();
        executor.shutdown();

    }
}
