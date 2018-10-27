package com.demo.parseTree;

public class Person {
    private int id;
    private String name;
    private int pid;
    private String partnerName;

    public Person(int id, String name, int pid, String partnerName) {
        this.id = id;
        this.name = name;
        this.pid = pid;
        this.partnerName = partnerName;
    }

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

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }
}
