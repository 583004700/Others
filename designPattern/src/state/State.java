package state;

public abstract class State {
    protected String name;
    public abstract void hanlder(Context context);
    public void say(){
        System.out.println(name);
    }
}
