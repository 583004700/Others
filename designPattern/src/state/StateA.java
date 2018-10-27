package state;

public class StateA extends State{
    public StateA(){
        this.name = "状态A";
    }
    @Override
    public void hanlder(Context context){
        context.state = new StateB();
    }
}
