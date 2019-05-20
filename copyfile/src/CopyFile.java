import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//last update 2019/3/20 14:17
public class CopyFile {
    public static void main(String[] args) throws Exception{
        String yyyyMMdd = new SimpleDateFormat("yyyyMMdd").format(new Date());

        String localPre = "D:\\IdeaProjects\\jxsw\\21省级标准大企业系统\\03代码类\\01源代码（江西）";
        String toPre = "D:\\IdeaProjects\\update\\21省级标准大企业系统\\"+yyyyMMdd;

        localPre = "D:\\IdeaProjects\\jxsw\\江西国地税合并版本";
        toPre = "D:\\IdeaProjects\\update\\江西国地税合并版本\\"+yyyyMMdd;

        List<String> paths = Arrays.asList("/daieweb/ydglgxh/coreconfig/DAOConfig/ydcz_zyfk_jxgs_dao.xml",
                "/daieweb/ydglgxh/showconfig/webfaster-config/ydglgxh_xxjs_routes.xml");

        for(int i=0;i<paths.size();i++) {
            copyFile(localPre + paths.get(i), toPre + paths.get(i));
        }
    }

    public static void copyFile(String filePath,String toPath) throws Exception{
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        File toFile = new File(toPath);

        if(!toFile.getParentFile().exists()){
            toFile.getParentFile().mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(toFile);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        byte[] b = new byte[1024];
        int len = 0;

        while((len = bufferedInputStream.read(b))!=-1){
            bufferedOutputStream.write(b,0,len);
        }

        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        fileOutputStream.close();
        bufferedInputStream.close();
        fileInputStream.close();
    }
}
