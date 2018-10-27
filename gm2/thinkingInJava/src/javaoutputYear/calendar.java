package javaoutputYear;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class calendar {
    public static int year;
    public static int weekDay;

    public static void main(String[] args) throws Exception{
        System.out.println("请输入年份");
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);
        String s = in.readLine();
        year = Integer.parseInt(s);
        if(year < 1){
            System.out.println("输入的年份不小于1");
            return;
        }
        weekDay = firstDayOfYear(year);
        System.out.println("                "+year+"年");
        System.out.println("================================================");
        for(int i=1;i<=12;i++){
            System.out.println();
            printMonth(i);
            System.out.println();
        }
    }

    public static void printMonth(int m){
        printHead(m);
        int days = daysOfMonth(m);
        for(int i=1;i<=days;i++){
            if(i<10){
                System.out.print("     "+i);
            }else {
                System.out.print("    " + i);
            }
            weekDay = (weekDay+1)%7;
            if(weekDay==0){
                System.out.println();
                System.out.print("    ");
            }
        }
    }

    public static int daysOfMonth(int m){
        switch (m){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if(isLeapYear(year)){
                    return 29;
                }else{
                    return 28;
                }
        }
        return 0;
    }

    public static void printHead(int m){
        System.out.println("  "+m+"月    日    一    二    三    四    五    六");
        System.out.print("    ");
        for(int i=1;i<=weekDay;i++){
            System.out.print("      ");
        }
    }

    public static int firstDayOfYear(int y){
        int n = 0;
        n = y * 365;
        for(int i=1;i<y;i++){
            if(isLeapYear(i)){
                n+=1;
            }
        }
        return n%7;
    }

    public static boolean isLeapYear(int y){
        return ((y%4==0 &&y%100!=0) || y%400==0);
    }
}
