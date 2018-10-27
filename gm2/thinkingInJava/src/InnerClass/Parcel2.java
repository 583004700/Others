package InnerClass;

public class Parcel2 {
    class Content{
        private int i = 11;
        public int value(){
            return i;
        }
    }

    class Destination{
        private String label;
        Destination(String whereTo){
            this.label = whereTo;
        }
        String readLabel(){
            return this.label;
        }
    }

    public Destination to(String s){
        return new Destination(s);
    }

    public Content content(){
        return new Content();
    }

    public void ship(String dest){
        Content c = new Content();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel()+c.value());
    }

    public static void main(String[] args){
        Parcel2 p = new Parcel2();
        p.ship("北京");

        Parcel2 q = new Parcel2();
        Parcel2.Content c = q.content();
        Parcel2.Destination destination = q.to("北京");

    }
}
