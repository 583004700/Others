package wait_notify_size5;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    private static List list = new ArrayList();
    public static void addString(){
        list.add("anyString");
    }
    public static int size(){
        return list.size();
    }
}