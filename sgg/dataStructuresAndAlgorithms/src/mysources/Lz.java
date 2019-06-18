package mysources;

import java.util.ArrayList;
import java.util.List;

public class Lz {
    public static List<LzC> lzs = new ArrayList<LzC>();

    static{
        lzs.add(new LzC(1));
        lzs.add(new LzC(2));
        lzs.add(new LzC(3));
    }

    public static void main(String[] args) {
        f(lzs.get(0));
    }

    public static void f(LzC lz){
        f(lzs.get(lz.no+1));
        for(int i=0;i<=5;i++){
            lz.fruit = i;
        }
        if(lz.no == 3){
            return;
        }
    }
}

class LzC{
    public int fruit;
    public int no;

    public LzC(int no) {
        this.no = no;
    }
}
