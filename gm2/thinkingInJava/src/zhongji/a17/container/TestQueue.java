package zhongji.a17.container;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class TestQueue {
    public static void main(String[] args) {
        List<String> strs = Arrays.asList("1","2","3","90","87","54");
        LinkedList<String> linkedList = new LinkedList<String>(strs);
        PriorityQueue<String> priorityQueue = new PriorityQueue<String>(strs);
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(10);
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<String>(strs);
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<String>(strs);
        PriorityBlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<String>(strs);

        printQueue(linkedList);
        printQueue(priorityQueue);
    }

    public static void printQueue(Queue<?> queue){
        while(queue.peek() != null){
            System.out.println(queue.remove());
        }
    }
}
