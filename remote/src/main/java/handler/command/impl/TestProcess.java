package handler.command.impl;

public class TestProcess {
    public static void main(String[] args) throws Exception{
        Process process = Runtime.getRuntime().exec("mysql");
        System.out.println(process);
    }
}
