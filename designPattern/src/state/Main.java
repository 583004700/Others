package state;

import simpleFactory.Operation;
import simpleFactory.OperationFactory;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Context c = new Context(new StateA());
        c.request();
        c.request();
        c.request();
        c.request();
    }
}
