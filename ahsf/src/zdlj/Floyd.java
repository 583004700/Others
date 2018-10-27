package zdlj;

public class Floyd extends TuLjjz {
    public static void main(String []args){
        Floyd f = new Floyd();
        f.luYxt(4,8);

        //计算任意两点之间的最短路径
        f.floyd();

        f.printResult();
    }

    public void floyd(){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=n;k++){
                    if(e[i][k]+e[k][j] < e[i][j]){
                        e[i][j] = e[i][k]+e[k][j];
                    }
                }
            }
        }
    }

}
