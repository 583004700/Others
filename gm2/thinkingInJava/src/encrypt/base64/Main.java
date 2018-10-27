package encrypt.base64;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Base64;

public class Main {
    public static void main(String[] args){
        InputStream in = Main.class.getResourceAsStream("a.jpg");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            byte[] b = new byte[1024];
            int len;
            while ((len = in.read(b)) != -1) {
                byteArrayOutputStream.write(b,0,len);
            }
            byteArrayOutputStream.close();
        }catch (Exception e){

        }finally {

        }

        byte[] bytes = byteArrayOutputStream.toByteArray();

        String bStr = Base64.getEncoder().encodeToString(bytes);

        System.out.println(bytes.length);
        System.out.println(bStr);
    }
}
