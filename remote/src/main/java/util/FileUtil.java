package util;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {
    public static SimpleDateFormat simpleDateFormat;

    static{
        simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd, HH:mm");
    }

    /**
     * 获取文件名称
     * @param fullPath
     * @return
     */
    public static String getName(String fullPath){
        String fileName = "";
        if(fullPath.contains("\\") || fullPath.contains("/")){
            int last = fullPath.lastIndexOf("\\");
            int last2 = fullPath.lastIndexOf("/");
            int maxLast = Math.max(last,last2);
            fileName = fullPath.substring(maxLast+1,fullPath.length());
        }
        return fileName;
    }

    /**
     * 获取文件路径
     * @param fullPath
     * @return
     */
    public static String getPath(String fullPath){
        String path = "";
        if(fullPath.contains("\\") || fullPath.contains("/")){
            int last = fullPath.lastIndexOf("\\");
            int last2 = fullPath.lastIndexOf("/");
            int maxLast = Math.max(last,last2);
            path = fullPath.substring(0,maxLast+1);
        }
        return path;
    }

    /**
     * 获取文件图标
     * @return
     */
    public static Icon getFileSmallIcon(File file){
        if (file != null && file.exists()) {
            FileSystemView fsv = FileSystemView.getFileSystemView();
            return fsv.getSystemIcon(file);
        }
        return null;
    }

    /**
     * 获取文件大小
     * @param file
     * @return
     */
    public static String getFileLengthStr(File file){
        if(!file.exists() || file.isDirectory()){
            return "";
        }
        DecimalFormat df = new DecimalFormat("#.00");
        long length = file.length();
        if(length < 1024){
            return length+" Bytes";
        }else if(length < Math.pow(1024,2)){
            return df.format(length / Math.pow(1024,1)) + "KB";
        }else if(length < Math.pow(1024,3)){
            return df.format(length / Math.pow(1024,2)) + "MB";
        }else if(length < Math.pow(1024,4)){
            return df.format(length / Math.pow(1024,3)) + "GB";
        }
        return "";
    }

    /**
     * 获取文件类型
     * @param file
     * @return
     */
    public static String getType(File file){
        if(file.isDirectory()){
            return "文件夹";
        }else{
            return "文件";
        }
    }

    /**
     * 获取最后修改时间
     * @param file
     * @return
     */
    public static String getlastModified(File file){
        long last = file.lastModified();
        Date date = new Date(last);
        return simpleDateFormat.format(date);
    }

}
