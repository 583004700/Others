package day13;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args){
        String content = "I am noob " +
                "from runoob.com.";

        String pattern = ".*runoob.*";

        Pattern p = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(content);
        System.out.println(m.find());
        System.out.println(m.find());
        boolean isMatch = m.matches();
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
        System.out.println(m.group());
    }
}
