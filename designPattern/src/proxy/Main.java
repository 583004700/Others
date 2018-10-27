package proxy;

import decorator.BigTrouser;
import decorator.Persion;
import decorator.TShirts;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        SchoolGirl schoolGirl = new SchoolGirl();
        schoolGirl.name = "李娇娇";
        Proxy daili = new Proxy(schoolGirl);
        daili.giveDolls();
        daili.giveFlowers();
        daili.giveChocolate();
    }
}
