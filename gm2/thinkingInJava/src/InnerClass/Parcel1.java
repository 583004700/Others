package InnerClass;

public class Parcel1 {
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

    public void ship(String dest){
        Content c = new Content();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args){
        Parcel1 p = new Parcel1();
        p.ship("北京");

    }
}
