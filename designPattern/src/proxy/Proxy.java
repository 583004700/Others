package proxy;

public class Proxy implements GiveGift{
    Pursuit pursuit;
    public Proxy(SchoolGirl mm){
        this.pursuit = new Pursuit(mm);
    }
    public void giveDolls(){
        pursuit.giveDolls();
    }
    public void giveFlowers(){
        pursuit.giveFlowers();
    }
    public void giveChocolate(){
        pursuit.giveChocolate();
    }
}
