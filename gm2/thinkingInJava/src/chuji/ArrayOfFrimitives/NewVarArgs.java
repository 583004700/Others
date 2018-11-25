package chuji.ArrayOfFrimitives;

public class NewVarArgs {
    public static void main(String[] args){
        printArray(5,"你好");
        printArray(6);
    }


    static void printArray(int i,Object... args){
        System.out.println(args.getClass());
        System.out.println(i);
        for(Object obj:args){
            System.out.print(obj+"    ");
        }
        System.out.println();
    }
}
