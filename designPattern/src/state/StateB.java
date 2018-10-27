package state;

public class StateB extends State{
    public StateB(){
        this.name = "状态B";
    }
    @Override
    public void hanlder(Context context){
        context.state = new StateA();
    }
}
