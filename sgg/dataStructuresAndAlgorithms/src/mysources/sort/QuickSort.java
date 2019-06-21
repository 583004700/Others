package mysources.sort;

import java.util.Arrays;

public class QuickSort {
    public static int[] arr = {3,9,-1,10,-2,7,9,5,3,2,8,6,-10,-9,-1};

    public static void main(String[] args) {
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int jz = arr[left];
        int oldLeft = left;
        int oldRight = right;
        boolean b = false;
        for(;right>left;right--){
            if(arr[right]<jz){
                for(;left<right;left++){
                    if(arr[left]>jz){
                        swap(arr,left,right);
                        break;
                    }
                }
            }
        }
        swap(arr,oldLeft,left);
        quickSort(arr,oldLeft,left-1);
        quickSort(arr,left+1,oldRight);
    }

    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
