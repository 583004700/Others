package zhongji.a15.generics;

import java.awt.*;

interface HasColor{
    Color getColor();
}

class Colored<T extends HasColor>{
    T item;
    Colored(T item){
        this.item=item;
    }

    Color color(){
        return item.getColor();
    }
}

class Dimension{public int x,y,z;}

class ColoredDimension<T extends Dimension & HasColor>{
    T item;
    ColoredDimension(T item){
        this.item = item;
    }
    T getItem(){
        return item;
    }
    Color getColor(){
        return item.getColor();
    }
}

public class BasicBounds {
}
