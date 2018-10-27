package command;

public class BakeMuttonCommand extends Command{

    public BakeMuttonCommand(Barbecuer barbecuer){
        super(barbecuer);
    }

    public void ExcuteCommand(){
        this.receiver.BakeMutton();
    }
}
