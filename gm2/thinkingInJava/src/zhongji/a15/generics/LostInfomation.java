package zhongji.a15.generics;

import java.util.*;

class Frob{}
class Fnorkle{}
class Quark<Q>{}
class particle<POSITION,MOMENTUM>{}


public class LostInfomation {
    public static void main(String[] args) {
        List<Frob> list = new ArrayList<Frob>();
        Map<Frob,Fnorkle> map = new HashMap<Frob,Fnorkle>();
        Quark<Fnorkle> quark = new Quark<Fnorkle>();
        particle<Long,Double> p = new particle<Long,Double>();

        System.out.println(Arrays.asList(list.getClass().getTypeParameters()));
        System.out.println(Arrays.asList(map.getClass().getTypeParameters()));
        System.out.println(Arrays.asList(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.asList(p.getClass().getTypeParameters()));
    }
}
