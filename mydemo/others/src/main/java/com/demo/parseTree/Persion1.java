package com.demo.parseTree;

import java.util.ArrayList;
import java.util.List;

public class Persion1 {
    private int id;
    private String name;

    public Persion1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private List<Persion1> subs = new ArrayList<Persion1>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Persion1> getSubs() {
        return subs;
    }

    public void setSubs(List<Persion1> subs) {
        this.subs = subs;
    }
}
