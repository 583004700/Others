package iterator;

public class List implements Iterator{
    public Integer [] a = new Integer[10];

    public List(){
        a[0] = 3;
        a[1] = 4;
        a[2] = 5;
        a[3] = 6;
        a[4] = 7;
        a[5] = 8;
        a[6] = 9;
        a[7] = 34;
        a[8] = 35;
        a[9] = 36;
    }

    int currentIndex = 0;
    int get(int index){
        return a[index];
    }
    public boolean hasNext(){
        if(currentIndex < a.length){
            return true;
        }
        return false;
    }
    @Override
    public Integer next(){
        int next = a[currentIndex];
        currentIndex = currentIndex + 1;
        return next;
    }
}
