package decorator;

public class Persion {

    private String name;
    public Persion(){

    }
    public Persion(String name){
        this.name = name;
    }
    public void show(){
        System.out.println("装饰的"+this.name);
    }
}
