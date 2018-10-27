package decorator;

public class TShirts extends Finery{
    public TShirts(Persion persion){
        super(persion);
    }
    @Override
    public void show(){
        System.out.println("大T恤");
        super.show();
    }
}
