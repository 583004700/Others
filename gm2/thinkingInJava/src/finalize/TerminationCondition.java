package finalize;

public class TerminationCondition {
    public static void main(String[] args){
        Book book = new Book(true);
        book.checkIn();
        new Book(true);
        //强制垃圾回收，触发对象的finalize方法
        //不强制回收的话可能由虚拟机在某种特定条件下才执行
        System.gc();
    }
}

class Book{
    boolean ckeckedOut = false;
    Book(boolean checkOut){
        this.ckeckedOut = checkOut;
    }

    void checkIn(){
        this.ckeckedOut = false;
    }

    @Override
    protected void finalize() throws Throwable {
        if(this.ckeckedOut){
            System.out.println("Error");
        }
    }
}
