package tdbl;

import java.util.Scanner;

public class TDfs {
    public static Scanner scanner;
    public static int[][] e;
    public static int maxInt;
    public static int[] a;
    public static int n;
    public static int m;

    public TDfs() {
    }

    public static void main(String[] args) {
        n = scanner.nextInt();
        m = scanner.nextInt();

        int i;
        int j;
        for(i = 1; i <= n; ++i) {
            for(j = 1; j <= n; ++j) {
                if (i == j) {
                    e[i][j] = 0;
                } else {
                    e[i][j] = maxInt;
                }
            }
        }

        for(i = 1; i <= m; ++i) {
            j = scanner.nextInt();
            int b = scanner.nextInt();
            e[j][b] = 1;
            e[b][j] = 1;
        }

        a[1] = 1;
        dfs(1);
    }

    public static void dfs(int dd) {
        System.out.println(dd);

        for(int i = 1; i <= n; ++i) {
            if (e[dd][i] == 1 && a[i] != 1) {
                a[i] = 1;
                dfs(i);
            }
        }

    }

    static {
        scanner = new Scanner(System.in);
        e = new int[101][101];
        maxInt = 99999999;
        a = new int[101];
    }
}
