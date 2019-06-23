package mysources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileO {
    public static void copy(String src,String dis) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(new File(src));
        FileOutputStream fileOutputStream = new FileOutputStream(new File(dis),true);

        byte[] b = new byte[1024];

        //从配置中读取
        int count = 1000;

        int res = -1;
        fileInputStream.skip(count*b.length);
        while((res = fileInputStream.read(b))!=-1){
            fileOutputStream.write(b,0,res);
            fileOutputStream.flush();
            count++;
            //写入配置文件中
            System.out.println(count);
//            if(count == 1000){
//                //模拟io复制被终止
//                break;
//            }
        }
    }

    public static void main(String[] args) throws Exception{
        copy("F:/httpClient-0.0.1-SNAPSHOT.jar","F:/httpClient-0.0.1-SNAPSHOT.jar2");
    }
}
