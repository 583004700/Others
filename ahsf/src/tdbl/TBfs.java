package tdbl;

import java.util.Scanner;

public class TBfs {
    public static int[][] e = new int[101][101];
    public static int a[] = new int[101];
    public static int maxInt = 99999999;
    public static Scanner scanner = new Scanner(System.in);
    public static int n;
    public static int m;
    public static Queue q = new Queue();
    public static void main(String []args){
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i == j){
                    e[i][j] = 0;
                }else{
                    e[i][j] = maxInt;
                }
            }
        }

        for(int i=1;i<=m;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            e[a][b] = 1;
            e[b][a] = 1;
        }

        a[1] = 1;
        bfs(1);

    }


    public static void bfs(int dd){
        System.out.println(dd);
        for(int i=1;i<=n;i++){
            if(e[dd][i] == 1 && a[i] != 1){
                q.qAdd(i);
                a[i] = 1;
            }
        }
        if(q.isEmpty()){
            return;
        }
        bfs(q.qDel());
    }
}

class Queue{
    private int[] dataArr = new int[101];
    private int zzStart = 1;
    private int zzEnd = 1;
    public void qAdd(int data){
        dataArr[zzEnd] = data;
        zzEnd++;
    }

    public int qDel(){
        int d = dataArr[zzStart];
        zzStart++;
        return d;
    }

    public boolean isEmpty(){
        return zzStart == zzEnd;
    }
}
