package zhongji.a14.typeinfo;

public class Student {
    private String name;
    public static Student getInstance(){
        Student s = new Student();
        s.name = "张三";
        return s;
    }
}
