package enumt;

public class Main {
    public static void main(String[] args){
        Spiciness spiciness = Spiciness.MILD;
        System.out.println(spiciness.name());

        for(Spiciness spiciness1:Spiciness.values()){
            System.out.println(spiciness1.name()+"  "+spiciness1.ordinal());
        }

        selected(Spiciness.MILD);

        System.out.println(spiciness.size);
    }

    public static void selected(Spiciness spiciness){
        switch (spiciness){
            case MILD:
                System.out.println("MILD");
                break;
            case MEDIUM:
                System.out.println("MEDIUM");
                break;
        }
    }
}
