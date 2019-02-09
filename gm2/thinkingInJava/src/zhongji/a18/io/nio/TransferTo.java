package zhongji.a18.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class TransferTo {
    public static void main(String[] args) throws Exception{
        FileChannel in = new FileInputStream("").getChannel();
        FileChannel out = new FileOutputStream("").getChannel();
        in.transferTo(0,in.size(),out);
        //或者
        //out.transferFrom(in,0,in.size());
    }
}

