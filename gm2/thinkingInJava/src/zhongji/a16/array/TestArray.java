package zhongji.a16.array;

import java.util.Arrays;
import java.util.Collections;

public class TestArray {
    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i,47);
        Arrays.fill(j,99);
        System.out.println("i = "+Arrays.toString(i));
        System.out.println("j = "+Arrays.toString(j));
        //数组复制
        System.arraycopy(i,0,j,0,i.length);
        System.out.println("j = "+Arrays.toString(j));

        Integer[] a1 = new Integer[10];
        Integer[] a2 = new Integer[10];
        Arrays.fill(a1,1024);
        Arrays.fill(a2,1024);
        System.out.println("Arrays.equals(a1,a2)="+Arrays.equals(a1,a2));

        a1[3] = 99;
        Arrays.sort(a1, Collections.reverseOrder());
        System.out.println(Arrays.toString(a1));
    }
}
