package zhongji.a14.typeinfo;

import java.io.Serializable;

class Candy{
    static {System.out.println("loading Candy");}
}

class Gum implements Serializable{
    static {System.out.println("loading Gum");}
}

class Cookie{
    static {System.out.println("loading Cookie");}
}


public class SweetShop {
    public static void main(String[] args) throws Exception{
        System.out.println("inside main");
        new Candy();
        System.out.println("after create Candy");
        try{
            Class clazz = Class.forName("zhongji.a14.typeinfo.Gum");
            System.out.println(clazz.getName());
            System.out.println(clazz.isInterface());
            System.out.println(clazz.getSimpleName());
            System.out.println(clazz.getSuperclass().newInstance());
            System.out.println(clazz.getInterfaces()[0].getName());
        }catch (ClassNotFoundException e){
            System.out.println("Couldn't found Gum");
            e.printStackTrace();
        }
        System.out.println("after Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("after create Cookie");

        Class<Integer> c = int.class;
        System.out.println(c.getName());
    }
}
