package zdlj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 邻接表表示图
 */
public class TuLjb {
    //顶点个数
    public int n;
    //边的条数
    public int m;

    public int[] u;
    public int[] v;
    public int[] w;

    public int[] first;
    public int[] next;
    public static Scanner scanner = new Scanner(System.in);

    public TuLjb(int n,int m){
        this.n = n;
        this.m = m;
        this.u = new int[m+1];
        this.v = new int[m+1];
        this.w = new int[m+1];
        this.first = new int[n+1];
        this.next = new int[m+1];
    }

    /**
     * 录入有向图
     */
    public void LuYxt(){
        for(int i=1;i<=m;i++) {
            int d1 = scanner.nextInt();
            int d2 = scanner.nextInt();
            int jl = scanner.nextInt();
            this.u[i] = d1;
            this.v[i] = d2;
            this.w[i] = jl;
            this.next[i] = this.first[d1];
            this.first[d1] = i;
        }
    }

    public List<Integer> Cb(int dd){
        ArrayList<Integer> cb = new ArrayList<Integer>();
        int d1 = this.first[dd];
        while(d1 != 0){
            cb.add(d1);
            d1 = this.next[d1];
        }
        return cb;
    }
}
