package zhongji.a18.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Echo {
    public static void main(String[] args) throws Exception{
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=stdin.readLine())!=null && s.length()>0){
            System.out.println(s);
        }
    }
}
