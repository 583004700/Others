package prototype.FTest;

public class S extends F{
    public int age;
    public String name = "sss";
    public String toJsonString1(){
        System.out.println("super*****"+this.say()+"     super.name******"+super.name);
        return this.toJsonString();
    }

    @Override
    public String say(){
        return super.say();
    }
}
