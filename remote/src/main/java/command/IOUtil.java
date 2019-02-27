package command;

import java.io.*;

public class IOUtil {

    public static void readStrToOutputStream(InputStream inputStream, String charsetName, OutputStream outputStream) throws Exception{
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream));
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,charsetName));
            String line = null;
            while((line = br.readLine()) != null){
                printWriter.println(line);
                printWriter.flush();
                //System.out.println(outputStream.toString()+inputStream+":"+line);
            }
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    /**
     * 读取数据到结束，并返回字符串
     * @param inputStream
     * @param charsetName
     * @return
     */
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
    /**
     * 只读取一行数据，并返回字符串
     * @param inputStream
     * @param charsetName
     * @return
     * @throws Exception
     */
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