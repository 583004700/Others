package zhongji.a15.generics;

class Generic<T>{}

public class ArrayOfGeneric<T> {
    static final int size = 100;
    static Generic<Integer>[] gia;

    private T[] array;

    public ArrayOfGeneric(){}

    public ArrayOfGeneric(int sz){
        array = (T[])new Object[sz];
    }

    public void put(int index,T item){
        array[index] = item;
    }

    public T[] rep(){return array;}

    public static void main(String[] args) {
        //运行时会报错
        //gia = (Generic<Integer>[]) new Object[size];
        gia = (Generic<Integer>[]) new Generic[size];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<Integer>();


        ArrayOfGeneric<Integer> gai = new ArrayOfGeneric<Integer>(10);
        //也不能强制转为Integer[]
        Object[] oa = gai.rep();
    }
}
