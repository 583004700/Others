package com.demo.cas;

public class CasCounnter {
    private com.demo.cas.SimulatedCAS value = new com.demo.cas.SimulatedCAS();
    private int i;
    public int increment(){
        do{
            i = value.getValue();
        }while(i!=value.comparedAndSwap(i,i+1));
        return i+1;
    }

    public int getValue(){
        return i+1;
    }
}
