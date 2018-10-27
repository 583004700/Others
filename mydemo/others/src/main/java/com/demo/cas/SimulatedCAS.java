package com.demo.cas;

public class SimulatedCAS {
    private int value;

    public int getValue() {
        return value;
    }

    public synchronized int comparedAndSwap(int expectedValue, int newValue){
        int oldValue = value;
        if(expectedValue == value){
            value = newValue;
        }
        return oldValue;
    }

    public boolean compareAndSet(int expectedValue, int newValue){
        return expectedValue == comparedAndSwap(expectedValue,newValue);
    }
}
