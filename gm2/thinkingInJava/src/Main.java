public class Main {
    public static void main(String[] args){
        printStart(7,1,1);
        printStart(9,1,1);
    }

    public static void printStart(int n,int count,int row){
        if(n<count){
            return;
        }
        for(int i=0;i<=n/2-row;i++){
            System.out.print(" ");
        }
        for(int i=0;i<row*2-1;i++){
            System.out.print("*");
        }
        System.out.println();
        if(count<=n/2) {
            printStart(n, count+1,row + 1);
        }else{
            printStart(n, count+1,row -1);
        }
    }
}
