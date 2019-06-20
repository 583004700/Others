package mysources.sort;

import java.util.Arrays;

public class InsertSort {

    public static int[] arr = {3,9,-1,10,-2};

    public static void main(String[] args) {
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int insertIndex = 0;
            boolean b = false;
            for(int j=0;j<i;j++){
                if(!b){
                    if(arr[i]<arr[j]){
                        b = true;
                        insertIndex = j;
                    }
                }else{
                    int temp = arr[j];
                    arr[j+1] = temp;
                    arr[insertIndex] = arr[i];
                }
            }
        }
    }
}
