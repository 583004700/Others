package com.demo.gzip;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipUtils {
    public static byte[] gzip(byte[] data) throws Exception{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        GZIPOutputStream gos = new GZIPOutputStream(bos);
        gos.write(data);
        gos.flush();
        gos.close();
        byte[] ret = bos.toByteArray();
        bos.close();
        return ret;
    }

    public static byte[] unGzip(byte[] data) throws Exception{
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        GZIPInputStream gis = new GZIPInputStream(bis);
        byte[] buf = new byte[1024];
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int num = -1;
        while((num = gis.read(buf,0,buf.length))!=-1){
            bos.write(buf,0,num);
        }
        gis.close();
        bis.close();
        byte[] ret = bos.toByteArray();
        return ret;
    }

    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("d:/test.png");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        fis.close();
        System.out.println("原始大小"+data.length);
        byte[] p = gzip(data);
        System.out.println("压缩后大小"+p.length);
        byte[] j = unGzip(p);
        System.out.println("还原后大小"+j.length);

    }
}
