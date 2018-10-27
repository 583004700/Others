package zdlj;

import java.util.Scanner;

/**
 * 邻接矩阵表示图
 */
public class TuLjjz {
    public Scanner scanner = new Scanner(System.in);
    public int[][] e = new int[101][101];
    public int n;
    public int m;
    public int maxInt = 99999999;

    public void init(int a,int b){
        this.n = a;
        this.m = b;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j){
                    e[i][j]=0;
                }else{
                    e[i][j]= maxInt;
                }
            }
        }
    }

    public void luYxt(int a,int b){
        init(a,b);
        for(int i=1;i<=m;i++){
            int d1 = scanner.nextInt();
            int d2 = scanner.nextInt();
            int jl = scanner.nextInt();
            this.e[d1][d2] = jl;
        }
    }

    public void luWxt(int a,int b){
        init(a,b);
        for(int i=1;i<=m;i++){
            int d1 = scanner.nextInt();
            int d2 = scanner.nextInt();
            int jl = scanner.nextInt();
            this.e[d1][d2] = jl;
            this.e[d2][d1] = jl;
        }
    }

    public void printResult(){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(e[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
