package com.demo.yunxi.forkjoin.coin;

public class Coin {
    private final CoinWeight weight;

    public Coin(CoinWeight weight) {
        this.weight = weight;
    }

    public CoinWeight getWeight(){
        return weight;
    }

    @Override
    public String toString() {
        return "Coin:{weight:"+weight+"}";
    }
}
