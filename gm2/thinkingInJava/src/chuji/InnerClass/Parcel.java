package chuji.InnerClass;

public class Parcel {
    public Destination destination(String s){
        class PDestination implements Destination{
            private String Label;
            PDestination(String whereTo){
                this.Label = whereTo;
            }

            @Override
            public String readLabel() {
                return Label;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args){
        Parcel p = new Parcel();
        Destination d = p.destination("北京");
    }
}
