package com.demo.yunxi.forkjoin.service;

import com.demo.yunxi.forkjoin.coin.Coin;

public class CoinProcess implements IProcess{
    @Override
    public void process(Coin coin) {
        try {
            Thread.sleep(1);
        }catch (Exception e){

        }
    }
}
