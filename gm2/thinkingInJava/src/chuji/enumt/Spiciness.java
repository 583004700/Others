package chuji.enumt;

public enum Spiciness {
    NOT(10),MILD(20),MEDIUM(30);

    public int size;

    Spiciness(int size){
        this.size = size;
    }
}
