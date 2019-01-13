package zhongji.a15.generics;

interface FactoryI<T>{
    T create();
}

class Foo2<T>{
    private T x;
    public <F extends FactoryI<T>> Foo2(F factory){
        x = factory.create();
    }
}

class InterFactory implements FactoryI<Integer>{
    @Override
    public Integer create() {
        return 1;
    }
}

class Widget{
    public static class Factory implements FactoryI<Widget>{
        @Override
        public Widget create() {
            return new Widget();
        }
    }
}

public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<Integer>(new InterFactory());
        new Foo2<Widget>(new Widget.Factory());
    }
}
