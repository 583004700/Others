package composite;

public class Main {
    public static void main(String args[]){
        Component root = new Composite("根节点");
        Component leaf1 = new Leaf("->一级叶节点1");
        Component leaf2 = new Leaf("->一级叶节点2");
        root.add(leaf1);
        root.add(leaf2);

        Component component = new Composite("->一级分支");
        Component leaf3 = new Leaf("->->二级叶节点1");
        Component leaf4 = new Leaf("->->二级叶节点2");
        component.add(leaf3);
        component.add(leaf4);
        root.add(component);
        root.foreach();
    }
}
