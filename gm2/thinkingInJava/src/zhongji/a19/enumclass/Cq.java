package zhongji.a19.enumclass;

interface C{
    Outcome compare(R r);
}

enum Outcome{
    Y,S,P
}

enum R implements C{
    ST(Outcome.P,Outcome.S,Outcome.Y),JD(Outcome.S,Outcome.Y,Outcome.P),B(Outcome.Y,Outcome.P,Outcome.S);

    private Outcome a,b,c;
    R(Outcome a,Outcome b,Outcome c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Outcome compare(R r){
        switch (r){
            case ST:return a;
            case B:return b;
            case JD:return c;
        }
        return null;
    }
}

public class Cq {
    public static void main(String[] args) {
        System.out.println(R.JD.compare(R.JD));
        System.out.println(R.ST.compare(R.JD));
        System.out.println(R.B.compare(R.JD));
    }
}
