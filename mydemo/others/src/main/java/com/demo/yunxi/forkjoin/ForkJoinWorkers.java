package com.demo.yunxi.forkjoin;

import com.demo.yunxi.forkjoin.coin.Coin;
import com.demo.yunxi.forkjoin.coin.CoinBag;
import com.demo.yunxi.forkjoin.service.CoinBalance;
import com.demo.yunxi.forkjoin.service.CoinProcess;
import com.demo.yunxi.forkjoin.service.IBalance;
import com.demo.yunxi.forkjoin.service.IProcess;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinWorkers {
    private static class Worker extends RecursiveTask<Integer>{

        private static final int THRESHOLD = 500;
        private int fromIndex;
        private int toIndex;
        private Coin[] bag;
        private IBalance balance;

        public Worker(int fromIndex, int toIndex, Coin[] bag, IBalance balance) {
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
            this.bag = bag;
            this.balance = balance;
        }

        @Override
        protected Integer compute() {
            if(toIndex - fromIndex < THRESHOLD){
                int count = 0;
                for(int i=fromIndex;i<toIndex;i++){
                    if(!balance.weight(bag,i)){
                        count++;
                    }
                }
                return count;
            }else{
                int mid = (fromIndex+toIndex)/2;
                Worker worker1 = new Worker(fromIndex,mid,bag,balance);
                Worker worker2 = new Worker(mid,toIndex,bag,balance);
                invokeAll(worker1,worker2);
                return worker1.join()+worker2.join();
            }
        }
    }

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        IProcess process = new CoinProcess();
        IBalance balance = new CoinBalance(process);
        Worker worker = new Worker(0,40000, CoinBag.fillToBag(),balance);
        forkJoinPool.invoke(worker);
        System.out.println("count:"+worker.join()+"time:"+(System.currentTimeMillis()-startTime));
    }
}
