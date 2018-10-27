package com.demo.yunxi.forkjoin.service;

import com.demo.yunxi.forkjoin.coin.Coin;
import com.demo.yunxi.forkjoin.coin.CoinWeight;

public class CoinBalance implements IBalance{

    private IProcess process;

    public CoinBalance(IProcess process) {
        this.process = process;
    }

    @Override
    public boolean weight(Coin[] bag, int index) {
        if(bag[index].getWeight() == CoinWeight.LIGHT){
            process.process(bag[index]);
            return true;
        }
        return false;
    }
}
