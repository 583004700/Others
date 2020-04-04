package util;

import command.PropertiesConst;
import command.entity.OtherComputer;

import java.io.*;
import java.util.Date;

public class IOUtil {

    public static void readStrToOutputStream(InputStream inputStream, String charsetName, OutputStream outputStream) throws Exception{
        PrintWriter printWriter = IOUtil.wrapPrintWriter(outputStream, PropertiesConst.appEncoding);
        try {
            BufferedReader br = IOUtil.wrapBufferedReader(inputStream,charsetName);
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
            BufferedReader br = IOUtil.wrapBufferedReader(inputStream,charsetName);
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
            BufferedReader br = IOUtil.wrapBufferedReader(inputStream,charsetName);
            line = br.readLine();
        }catch (Exception e){
            throw new Exception(e);
        }
        return line;
    }

    public static PrintWriter wrapPrintWriter(OutputStream outputStream,String charsetName){
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(outputStream,charsetName));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return printWriter;
    }

    public static BufferedReader wrapBufferedReader(InputStream inputStream,String charsetName){
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream,charsetName));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }

    /**
     * 用于文件传输
     * @param inputStream
     * @param outputStream
     */
    public static void inputToOutput(InputStream inputStream,OutputStream outputStream){
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        try {
            byte[] b = new byte[1024000];
            int n = 0;
            while ((n = bufferedInputStream.read(b)) != -1) {
                bufferedOutputStream.write(b, 0, n);
                bufferedOutputStream.flush();
            }
            bufferedInputStream.close();
            bufferedOutputStream.close();
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
