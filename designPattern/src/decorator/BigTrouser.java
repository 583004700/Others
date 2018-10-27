package decorator;

public class BigTrouser extends Finery{
    public BigTrouser(Persion persion){
        super(persion);
    }
    @Override
    public void show(){
        System.out.println("垮裤");
        super.show();
    }
}
