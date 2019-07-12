package mysources.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Stack;

public class MergeSortNoRecursion {

    public static int arr[] = { 2,4,6,8,10 };//,1,3,5,7,9 ,10,11,13 , 8,7,12,45,22,3,24,456};

    public static void main(String[] args) {
//        int[] arr = new int[8000000];
//        for (int i = 0; i < 8000000; i++) {
//            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
//        }
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        int[] sortArr = new MergeSortNoRecursion().mergeSort(arr,0,arr.length-1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
        System.out.println(Arrays.toString(sortArr));
    }

    public static Stack<Param> paramStack = new Stack<Param>();
    public static Stack<int[]> resultStack = new Stack<int[]>();

    class Param{
        public int[] arr;
        public int left;
        public int right;

        public Param(int[] arr, int left, int right) {
            this.arr = arr;
            this.left = left;
            this.right = right;
        }
    }

    public int[] mergeSort(int[] arr,int left,int right){

        Param param = new Param(arr,left,right);
        paramStack.push(param);

        while(!paramStack.isEmpty()) {
            while(true) {
                if (param.left >= param.right) {
                    param = paramStack.pop();
                    //return new int[]{arr[left]};
                    resultStack.push(new int[]{param.arr[param.left]});
                    if(paramStack.isEmpty()){
                        return resultStack.pop();
                    }
                    param = paramStack.pop();
                    break;
                }

                int middle = (param.left + param.right) / 2;

                //int[] arr1 = mergeSort(arr, left, middle);
                param = new Param(param.arr,param.left,middle);
                paramStack.push(param);
            }

            int[] arr1 = resultStack.pop();

            while(true){
                if (param.left >= param.right) {
                    param = paramStack.pop();
                    //return new int[]{arr[left]};
                    resultStack.push(new int[]{param.arr[param.left]});
                    if(paramStack.isEmpty()){
                        return resultStack.pop();
                    }
                    param = paramStack.pop();
                    break;
                }

                int middle = (param.left + param.right) / 2;

                //int[] arr2 = mergeSort(arr, middle + 1, right);
                param = new Param(param.arr,middle + 1,param.right);
                paramStack.push(param);
            }

            int[] arr2 = resultStack.pop();

            int sortArr[] = new int[arr1.length + arr2.length];
            int arr1Index = 0;
            int arr2Index = 0;
            for (int i = 0; i < sortArr.length; i++) {
                if (arr1Index == arr1.length) {
                    sortArr[i] = arr2[arr2Index];
                    arr2Index++;
                    continue;
                } else if (arr2Index == arr2.length) {
                    sortArr[i] = arr1[arr1Index];
                    arr1Index++;
                    continue;
                } else if (arr1[arr1Index] < arr2[arr2Index]) {
                    sortArr[i] = arr1[arr1Index];
                    arr1Index++;
                } else if (arr2[arr2Index] <= arr1[arr1Index]) {
                    sortArr[i] = arr2[arr2Index];
                    arr2Index++;
                }
            }
            //return sortArr;
            resultStack.push(sortArr);
            Param oldParam = paramStack.peek();
            param = new Param(param.arr,(oldParam.left + oldParam.right) / 2 + 1,oldParam.right);
            paramStack.push(param);
        }
        return resultStack.pop();
    }

}
