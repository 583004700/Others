package chuji.InnerClass1;

import chuji.InnerClass.Content;
import chuji.InnerClass.Destination;

public class Parcel {
    private static class ParcelContents implements Content{
        private int i = 11;
        public int value(){
            return i;
        }
    }

    protected static class ParcelDestination implements Destination{
        private String Label;
        private ParcelDestination(String whereTo){
            Label = whereTo;
        }

        @Override
        public String readLabel() {
            return Label;
        }

        public static void f(){}
        static int x = 10;

        public static Destination destination(String s){
            return new ParcelDestination(s);
        }

        public static Content content(){
            return new ParcelContents();
        }

        static class AnotherLevel{
            public static void f(){}
            static int x = 10;
        }

        public static void main(String[] args){
            Content c = content();
            Destination d = destination("北京");

            //静态内部类可以不通过外部类的对象创建
            Parcel.ParcelDestination p = new Parcel.ParcelDestination("北京");

        }
    }

}
