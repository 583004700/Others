package decorator;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Persion p1 = new Persion("小明");
        TShirts t1 = new TShirts(p1);
        BigTrouser b1 = new BigTrouser(t1);
        b1.show();
    }
}
