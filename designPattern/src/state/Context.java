package state;

public class Context {
    public State state;
    public Context(State state){
        this.state = state;
    }
    public void request(){
        state.say();
        state.hanlder(this);
    }
}
