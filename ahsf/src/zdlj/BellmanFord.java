package zdlj;

public class BellmanFord extends TuLjb{
    public static final int max = 99999999;
    public int[] dis = new int[this.n+1];

    public BellmanFord(){
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
        BellmanFord b = new BellmanFord();
        b.LuYxt();
        for(int k=1;k<=b.n-1;k++) {
            int check = 0;
            for (int i = 1; i <= b.m; i++) {
                int u = b.u[i];
                int v = b.v[i];
                int w = b.w[i];
                if (b.dis[u] + w < b.dis[v]) {
                    b.dis[v] = b.dis[u] + w;
                    check = 1;
                }
            }
            if(check == 0) {
                break;
            }
        }

        for(int i=1;i<b.dis.length;i++){
            System.out.print(b.dis[i]);
        }
    }
}
