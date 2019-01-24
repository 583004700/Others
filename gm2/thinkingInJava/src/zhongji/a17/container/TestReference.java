package zhongji.a17.container;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

class VeryBig{
    private static final int SIZE = 10000;
    private long[] la = new long[SIZE];
    private String ident;
    public VeryBig(String id){
        ident = id;
    }
    public String toString(){return ident;}
    protected void finalize(){
        System.out.println("Finalizing "+ident);
    }
}

public class TestReference {
    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();

    public static void checkQueue(){
        Reference<? extends VeryBig> inq = rq.poll();
        if(inq != null){
            System.out.println("in queue:"+inq.get());
        }
    }

    public static void main(String[] args) throws Exception{
        int size = 10;
        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<SoftReference<VeryBig>>();
        for (int i = 0; i < 10; i++) {
            sa.add(new SoftReference<VeryBig>(new VeryBig("Soft "+i),rq));
        }

        LinkedList<WeakReference<VeryBig>> wa = new LinkedList<WeakReference<VeryBig>>();
        for (int i = 0; i < 10; i++) {
            wa.add(new WeakReference<VeryBig>(new VeryBig("Weak "+i),rq));
        }

        System.gc();

        Thread.sleep(1000);

        System.out.println(rq.poll());
    }
}
