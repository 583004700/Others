package command;

public class BakeChickenWingCommand extends Command{

    public BakeChickenWingCommand(Barbecuer barbecuer){
        super(barbecuer);
    }

    public void ExcuteCommand(){
        this.receiver.BakeChickenWing();
    }
}
