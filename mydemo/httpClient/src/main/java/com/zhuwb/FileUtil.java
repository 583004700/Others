package com.zhuwb;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileUtil {
    public static String read(String filePath) throws Exception{
        FileInputStream inputStream = new FileInputStream(new File(filePath));
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while(line != null){
            sb.append(line);
            line = br.readLine();
        }
        br.close();
        inputStream.close();
        return sb.toString();
    }

    public static void main(String[] args) throws Exception{
        byte[] bytes = {(byte)0xE4, (byte)0xBD, (byte)0xA0, (byte)0xE5, (byte)0xA5, (byte)0xBD};
        System.out.println(new String(bytes,"utf-8"));
        System.out.println(0xE4);
        System.out.println((byte)0xE4);
        System.out.println(0xBD);
        System.out.println((byte)0xBD);
    }
}
