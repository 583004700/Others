package iterator;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        List l = new List();
        while(l.hasNext()){
            System.out.println(l.next());
        }
    }
}
