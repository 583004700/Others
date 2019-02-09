package zhongji.a18.io;

import java.io.*;

public class Redirecting {
    public static void main(String[] args) throws Exception{
//        PrintStream console = System.out;
//        BufferedInputStream in = new BufferedInputStream(new FileInputStream(""));
//        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("")));
//        System.setIn(in);
//        System.setOut(out);
        command("CMD /C"+"dir");

    }


    public static void command(String command) throws Exception{
        boolean err = false;
        Process process = new ProcessBuilder(command.split(" ")).start();
        BufferedReader result = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String s;
        while((s = result.readLine())!=null){
            System.out.println(s);
        }
        while((s = error.readLine())!=null){
            System.out.println(s);
        }

    }
}
