package ArrayOfFrimitives;

public class VarArgs {
    public static void main(String[] args){
        printArray(new Object[]{new Integer(4),new Float(3.14),new Double(11.11)});
    }

    static void printArray(Object[] args){
        for(Object obj:args){
            System.out.print(obj+"    ");
        }
        System.out.println();
    }
}
