package zhongji.a14.typeinfo;

import java.util.Arrays;
import java.util.List;

abstract class Shape {
    void draw(){
        System.out.println(this+".draw");
    }
    public abstract String toString();
}

class Circle extends Shape {
    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangle";
    }
}

public class Shapes{
    public static void main(String[] args) throws Exception{
        List<Shape> shapes = Arrays.asList(new Circle(),new Square(),new Triangle());
        for(Shape shape:shapes){
            shape.draw();
        }
        Class c = Class.forName("Circle");

    }
}
