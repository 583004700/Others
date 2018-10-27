package decorator;

public class Finery extends Persion{
    Persion persion;
    public Finery(Persion persion){
        this.persion = persion;
    }

    @Override
    public void show(){
        persion.show();
    }
}
