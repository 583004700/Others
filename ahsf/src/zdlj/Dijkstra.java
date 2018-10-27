package zdlj;

public class Dijkstra extends TuLjjz {

    public int [] dis;
    public int [] book = new int[101];

    public static void main(String[] args){
        Dijkstra di = new Dijkstra();
        di.luYxt(6,9);
        di.dis = di.e[1];

        for (int k = 1; k <= di.n - 1; k++) {
            int minIndex = di.searchMinIndex();
            for (int i = 1; i <= di.n; i++) {
                if (di.e[minIndex][i] + di.e[1][minIndex] < di.dis[i]) {
                    di.dis[i] = di.e[minIndex][i] + di.e[1][minIndex];
                    di.book[minIndex] = 1;
                }
            }
        }

        di.printResult();
    }

    public int searchMinIndex(){
        int index = 2;
        int min = this.maxInt;
        for(int i=1;i<=n;i++){
            if(dis[i]<min && i!=1 && this.book[i]!=1){
                index = i;
                min = dis[index];
            }
        }
        return index;
    }
    @Override
    public void printResult(){
        for(int i=1;i<=this.n;i++){
            System.out.print(dis[i]+"   ");
        }
    }
}
