package zhongji.a17.container;

import java.util.LinkedList;

/**
 * 双端队列
 */
public class TestDeque {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.addFirst("a");
        linkedList.addFirst("b");
        System.out.println(linkedList);
    }
}
