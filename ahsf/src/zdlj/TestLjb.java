package zdlj;

public class TestLjb extends TuLjb{
    public TestLjb(){
        super(4,5);
    }

    public static void main(String[] args){
        TestLjb t = new TestLjb();
        t.LuYxt();
        System.out.println("--------------");
        System.out.println(t.Cb(1));
    }
}
