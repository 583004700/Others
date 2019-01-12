package scriptManager.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class FileUtil {
    public static String readString(InputStream inputStream) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];

            int length = -1;

            while ((length = inputStream.read(buffer)) != -1) {
                bos.write(buffer, 0, length);
            }
            bos.close();
            inputStream.close();
            return new String(bos.toByteArray(),"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
