package com.demo.yunxi.mergeSort;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/**
 * 多路归并排序
 */
public class MergeSort {

    /**
     * 被拆分的大文件
     */
    public static File f = new File("d:/test/number.txt");

    /**
     * 拆分的文件
     */
    public static List<FileInfo> files = new ArrayList<FileInfo>();

    public static void main(String[] args) throws Exception{
        bulidFile(200000);
        cutFile(2000);
        mergeSort();
        sort();
    }

    /**
     * 排序
     * @throws Exception
     */
    public static void sort() throws Exception{
        File sortF = new File("d:/test/sortNumber.txt");
        FileWriter fileWriter = new FileWriter(sortF.getAbsoluteFile());
        List<Integer> list = new ArrayList<Integer>();
        FileInfo fileInfo = new FileInfo(f);
        Integer i = null;
        while((i=fileInfo.getNext())!=null){
            list.add(i);
        }
        Collections.sort(list);
        list.forEach(o -> write(fileWriter,o.toString()));
        fileWriter.close();
    }

    public static void write(FileWriter fileWriter,String str){
        try {
            fileWriter.write(str+"\n");
        }catch (Exception e){

        }
    }

    /**
     * 多路归并排序
     * @throws Exception
     */
    public static void mergeSort() throws Exception{
        File sortF = new File("d:/test/mergeSortNumber.txt");
        FileWriter fileWriter = new FileWriter(sortF.getAbsoluteFile());
        while(files.size() > 0) {
            Integer min = Integer.MAX_VALUE;;
            Integer n = null;
            int z = 0;
            for (int i = 0; i < files.size(); i++) {
                FileInfo fileInfo = files.get(i);
                if(fileInfo.getMove()) {
                    n = fileInfo.getNext();
                }else{
                    n = fileInfo.getR();
                }
                if (n != null && n < min) {
                    min = n;
                    z = i;
                }
                if(n == null){
                    files.remove(i);
                    //重新定位到第一个文件，因为i会++，所以i赋值为-1
                    i = -1;
                    continue;
                }
            }
            if(n!=null && files.size()>0) {
                files.get(z).setMove(true);
                fileWriter.write(min.toString()+"\n");
            }
        }
        fileWriter.close();
    }

    /**
     * 拆分文件
     * @param number 每多少个数字拆分一次
     */
    public static void cutFile(int number) throws Exception{
        FileReader fileReader = new FileReader(f.getAbsoluteFile());
        char c = ' ';
        FileWriter fileWriter= null;
        int count = 1;
        while(c != '\uFFFF') {
            File file = new File("d:/test/number" + count + ".txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            files.add(new FileInfo(file));
            fileWriter = new FileWriter(file.getAbsoluteFile());
            List<Integer> l = new ArrayList<Integer>();
            for (int i = 0; i < number && c != '\uFFFF'; i++) {
                StringBuilder sb = new StringBuilder();
                while ((c = (char) fileReader.read()) != ' ' && c != '\uFFFF') {
                    sb.append(c);
                }
                String nu = sb.toString();
                if(StringUtils.isNotEmpty(nu)) {
                    Integer n = Integer.valueOf(nu);
                    l.add(n);
                }
            }
            Collections.sort(l);
            Iterator<Integer> iterator = l.iterator();
            while(iterator.hasNext()){
                fileWriter.write(iterator.next().toString()+" ");
            }
            fileWriter.close();
            count++;
        }
    }

    /**
     * 生成文件
     * @param count 数字个数
     * @throws Exception
     */
    public static void bulidFile(int count) throws Exception{
        Random random = new Random();
        if (!f.exists()) {
            f.createNewFile();
        }
        FileWriter fw = null;
        BufferedWriter bw = null;
        fw = new FileWriter(f.getAbsoluteFile());
        bw = new BufferedWriter(fw);
        String content = "";
        for(int i=0;i<count-1;i++) {
            int r = random.nextInt(count*2);
            content = String.valueOf(r > 0 ? r : -r);
            bw.write(content+" ");
        }
        int r = random.nextInt(count);
        content = String.valueOf(r > 0 ? r : -r);
        bw.write(content);
        bw.close();
        fw.close();
    }
}
