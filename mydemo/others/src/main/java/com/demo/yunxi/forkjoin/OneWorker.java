package com.demo.yunxi.forkjoin;

import com.demo.yunxi.forkjoin.coin.Coin;
import com.demo.yunxi.forkjoin.coin.CoinBag;
import com.demo.yunxi.forkjoin.service.CoinBalance;
import com.demo.yunxi.forkjoin.service.CoinProcess;
import com.demo.yunxi.forkjoin.service.IBalance;
import com.demo.yunxi.forkjoin.service.IProcess;

public class OneWorker {
    //count:26666time:33850
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        int count = 0;
        Coin[] bag = CoinBag.fillToBag();
        IProcess process = new CoinProcess();
        IBalance balance = new CoinBalance(process);
        for(int i=0;i<bag.length;i++){
            if(balance.weight(bag,i)){
                count++;
            };
        }
        System.out.println("count:"+count+"time:"+(System.currentTimeMillis()-startTime));
    }
}
