package composite;

public class Leaf extends Component{

    public Leaf(String name){
        super(name);
    }

    @Override
    public void add(Component c){

    }
    @Override
    public void remove(Component c){

    }
    @Override
    public void foreach(){
        System.out.println(this.name);
    }
}
