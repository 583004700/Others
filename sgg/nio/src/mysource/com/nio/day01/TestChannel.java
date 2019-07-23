package mysource.com.nio.day01;

import org.junit.Test;
import java.nio.channels.FileChannel.MapMode;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestChannel {
    //使用直接缓冲区完成文件的复制(内存映射文件)
    @Test
    public void test2() throws IOException {//2127-1902-1777
        long start = System.currentTimeMillis();

        FileChannel inChannel = FileChannel.open(Paths.get("f:/nio.zip"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("f:/nio1.zip"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        int count = 0;
        final int buffSize = Integer.MAX_VALUE;
        long s = 0;
        long pos = 0;
        long totalCount = inChannel.size() % buffSize == 0 ? inChannel.size() / buffSize : inChannel.size() / buffSize + 1;
        System.out.println("totalCount:"+totalCount);
        do{
            //内存映射文件
            pos = s * count;
            s = buffSize > inChannel.size() - pos ? inChannel.size() - pos : buffSize;
            MappedByteBuffer inMappedBuf = inChannel.map(MapMode.READ_ONLY, pos, s);
            MappedByteBuffer outMappedBuf = outChannel.map(MapMode.READ_WRITE, pos, s);
            outMappedBuf.put(inMappedBuf);
            count++;
            System.out.println("count："+count);
        }while(count < totalCount);


        inChannel.close();
        outChannel.close();

        long end = System.currentTimeMillis();
        System.out.println("耗费时间为：" + (end - start));
    }
}
