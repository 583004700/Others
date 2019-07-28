package util;

public class FileUtil {
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
}
