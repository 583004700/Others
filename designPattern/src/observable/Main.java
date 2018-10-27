package observable;

import prototype.Resume;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        TeacherSubject teacherSubject = new TeacherSubject();
        Observer studentObserver = new StudentObserver("张三",teacherSubject);
        Observer studentObserver2 = new StudentObserver("李四",teacherSubject);
        teacherSubject.setHomework("1、默写唐诗300首");
        teacherSubject.setHomework("2、哈哈");
    }
}
