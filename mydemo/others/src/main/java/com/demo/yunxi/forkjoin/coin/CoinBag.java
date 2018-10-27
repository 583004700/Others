package com.demo.yunxi.forkjoin.coin;

public class CoinBag {
    public static final int AMOUNT = 40000;

    public static Coin[] fillToBag(){
        Coin[] bag = new Coin[AMOUNT];
        for(int i=0;i<AMOUNT;i++){
            Coin coin = new Coin(i%3 == 0 ? CoinWeight.WEIGHT : CoinWeight.LIGHT);
            bag[i] = coin;
        }
        return bag;
    }

    public static void main(String[] args){
        Coin[] bag = fillToBag();
        for(Coin coin:bag){
            System.out.println(coin);
        }
    }
}
