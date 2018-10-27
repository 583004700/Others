package zdlj;

import java.util.ArrayList;
import java.util.List;

public class BellmanFordQueue extends TuLjb{
    public static final int max = 99999999;
    public int[] dis = new int[this.n+1];

    private int[] queue = new int[101];
    private int head = 1;
    private int tail = 1;
    private int[] book = new int[n+1];

    public BellmanFordQueue(){
        super(5,7);
        for(int i=1;i<=n;i++){
            if(i==1){
                dis[i] = 0;
            }else{
                dis[i] = max;
            }
        }
    }

    public static void main(String[] args){
        BellmanFordQueue b = new BellmanFordQueue();
        b.LuYxt();
        int dd = 1;
        b.queue[b.tail++] = dd;
        b.book[dd] = 1;
        while(b.head<b.tail) {
            dd = b.head;
            List<Integer> cbs = b.Cb(dd);
            for (int i = 0; i < cbs.size(); i++) {
                int k = cbs.get(i);
                int u = b.u[k];
                int v = b.v[k];
                int w = b.w[k];
                if (b.dis[u] + w < b.dis[v]) {
                    b.dis[v] = b.dis[u] + w;
                    if(b.book[v] != 1) {
                        b.queue[b.tail++] = v;
                        b.book[v] = 1;
                    }
                }
            }
            b.head++;
            b.book[dd] = 0;
        }

        for(int i=1;i<b.dis.length;i++){
            System.out.print(b.dis[i]+",");
        }
    }
}
