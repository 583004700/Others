package com.ry.xk.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * <描述类的作用>
 * 
 * @ClassName: Test
 * @author 幸仁强
 * @date 2018年5月21日
 */

public class Test
{

    /**
     * <描述方法的作用>
     * 
     * @Title: main
     * @author 幸仁强
     * @param args
     * @throws ParseException
     */

    public static void main(String[] args)
        throws ParseException
    {
        // double i = 1 / (1 + Math.exp(-1 * -0.55));
        // System.out.println(i);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person(1, "魏鑫", df.parse("2018-05-06")));
        personList.add(new Person(1, "魏鑫", df.parse("2018-05-07")));
        personList.add(new Person(1, "魏鑫", df.parse("2018-05-08")));
        personList.add(new Person(1, "魏鑫", df.parse("2018-05-09")));
        personList.add(new Person(2, "幸仁强", df.parse("2018-05-06")));
        personList.add(new Person(2, "幸仁强", df.parse("2018-05-07")));
        personList.add(new Person(2, "幸仁强", df.parse("2018-05-08")));
        personList.add(new Person(3, "朱未斌", df.parse("2018-05-06")));
        personList.add(new Person(3, "朱未斌", df.parse("2018-05-07")));
        personList.add(new Person(3, "朱未斌", df.parse("2018-05-08")));
        personList.add(new Person(3, "朱未斌", df.parse("2018-05-09")));
        personList.add(new Person(3, "朱未斌", df.parse("2018-05-10")));
        // List<Person> newList =
        // personList.stream().sorted(Comparator.comparing(Person::getCreateDateTime).reversed()).collect(Collectors.toList());
        List<Person> distinctList = personList.stream().sorted(Comparator.comparing(Person::getCreateDateTime).reversed()).collect(
            Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getId()))), ArrayList::new));
        distinctList.forEach((person) -> System.out.println(person.toString()));
    }

}
