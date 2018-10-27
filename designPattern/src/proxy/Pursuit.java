package proxy;

public class Pursuit implements GiveGift{

    SchoolGirl mm;

    public Pursuit(SchoolGirl schoolGirl){
        this.mm = schoolGirl;
    }

    public void giveDolls(){
        System.out.println(mm.name+"送你洋娃娃");
    }
    public void giveFlowers(){
        System.out.println(mm.name+"送你鲜花");
    }
    public void giveChocolate(){
        System.out.println(mm.name+"送你巧克力");
    }
}
