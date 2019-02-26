package command;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOUtil {
    public static String readStr(InputStream inputStream,String charsetName){
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,charsetName));
            String line = null;
            while((line = br.readLine()) != null){
                sb.append(line + "\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String readLinStr(InputStream inputStream,String charsetName) throws Exception{
        String line = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,charsetName));
            line = br.readLine();
        }catch (Exception e){
            throw new Exception(e);
        }
        return line;
    }
}
