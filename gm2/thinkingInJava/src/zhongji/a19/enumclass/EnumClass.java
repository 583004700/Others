package zhongji.a19.enumclass;

//枚举都继承自Enum
enum Shrubbery {GROUND,CRAWLING,HANGING}

public class EnumClass {
    public static void main(String[] args) {
        for(Shrubbery s : Shrubbery.values()){
            System.out.println(s+" 序号: "+s.ordinal());
        }
    }
}
