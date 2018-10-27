package factoryMethod;

public class VolunteerFactory implements IFactory{
    @Override
    public LeiFeng createLeiFeng(){
        return new Volunteer();
    }
}
