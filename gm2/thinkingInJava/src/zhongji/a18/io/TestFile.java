package zhongji.a18.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

class DirFilter implements FilenameFilter{
    private Pattern pattern;
    public DirFilter(String regex){
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        System.out.println(dir.getAbsolutePath());
        System.out.println(name);
        return pattern.matcher(name).matches();
    }
}

public class TestFile {

    public static void main(String[] args) {
//        System.out.println(File.pathSeparator);
//        System.out.println(File.pathSeparatorChar);
//
//        System.out.println(File.separator);
//        System.out.println(File.separatorChar);

//        Pattern p=Pattern.compile("\\d+");
//        Matcher m=p.matcher("aaa2223bb");
//        m.find();//匹配2223
//        m.start();//返回3
//        m.end();//返回7,返回的是2223后的索引号
//        m.group();//返回2223
//
//        Matcher m2=p.matcher("2223bb");
//        m2.lookingAt();   //匹配2223
//        m2.start();   //返回0,由于lookingAt()只能匹配前面的字符串,所以当使用lookingAt()匹配时,start()方法总是返回0
//        m2.end();   //返回4
//        m2.group();   //返回2223
//
//        Matcher m3=p.matcher("2223"); //如果Matcher m3=p.matcher("2223bb"); 那么下面的方法出错，因为不匹配返回false
//        m3.matches();   //匹配整个字符串
//        m3.start();   //返回0
//        m3.end();   //返回3,原因相信大家也清楚了,因为matches()需要匹配所有字符串
//        m3.group();   //返回2223


        File path = new File("./thinkingInJava/src");
        String[] list;

        list = path.list(new DirFilter("java8"));

        for(String dirItem : list){
            System.out.println("dirItem:"+dirItem);
        }


    }
}
