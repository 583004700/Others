package command;

import composite.Component;
import composite.Composite;
import composite.Leaf;

public class Main {
    public static void main(String args[]){
        Barbecuer barbecuer = new Barbecuer();
        Command command1 = new BakeChickenWingCommand(barbecuer);
        Command command2 = new BakeChickenWingCommand(barbecuer);
        Command command3 = new BakeMuttonCommand(barbecuer);
        Waiter girl = new Waiter();
        girl.setOrder(command1);
        girl.setOrder(command2);
        girl.setOrder(command3);
        girl.notifyCommand();
    }
}
