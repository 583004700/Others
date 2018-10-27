package com.ry.xk.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <描述类的作用>
 * 
 * @ClassName: Person
 * @author 幸仁强
 * @date 2018年5月26日
 */

public class Person
{
    private int id;

    private String name;

    private Date createDateTime;

    public int getId()
    {

        return id;
    }

    public void setId(int id)
    {

        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getCreateDateTime()
    {

        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime)
    {

        this.createDateTime = createDateTime;
    }

    public Person()
    {}

    public Person(int id, String name, Date createDateTime)
    {
        this.id = id;
        this.name = name;
        this.createDateTime = createDateTime;
    }

    @Override
    public String toString()
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return "Person{" + "id=" + id + ", name=" + name + ",createDateTime=" + df.format(createDateTime) + '}';
    }
}
