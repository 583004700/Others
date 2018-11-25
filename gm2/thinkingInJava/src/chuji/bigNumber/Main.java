package chuji.bigNumber;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        BigInteger b1 = new BigInteger("15487");
        BigInteger b2 = new BigInteger("8888888888888888888888888888");
        BigInteger b3 = b1.add(b2);
        System.out.println(b3.toString());

        BigDecimal bd = new BigDecimal("158448.48");
        BigDecimal bd2 = new BigDecimal("2.0");
        System.out.println(bd.divide(bd2));

        System.out.println();
    }
}
