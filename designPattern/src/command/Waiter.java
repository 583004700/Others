package command;

import java.util.ArrayList;
import java.util.List;

public class Waiter {
    private List<Command> orders = new ArrayList<Command>();
    public void setOrder(Command c){
        this.orders.add(c);
    }
    public void cancelOrder(Command c){
        this.orders.remove(c);
    }
    public void notifyCommand(){
        for(Command c : orders){
            c.ExcuteCommand();
        }
    }
}
