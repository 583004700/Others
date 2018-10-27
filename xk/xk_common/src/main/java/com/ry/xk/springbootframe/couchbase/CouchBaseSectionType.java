package com.ry.xk.springbootframe.couchbase;

public enum CouchBaseSectionType {
    MAIN(1), EXAMRESULT(2);
    private int index;

    CouchBaseSectionType(int index)
    {
        this.index = index;
    }

    public int getIndex()
    {
        return this.index;
    }
}
