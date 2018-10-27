package collections;


import java.util.*;

public class Main {

    public static void main(String[] args){

        Person p4 = new Person(4L,"小明");
        Person p3 = new Person(3L,"小李");

        Person p1 = new Person(1L,"小吴");
        Person p2 = new Person(1L,"小王");

        List<Person> persons = new ArrayList<Person>();
        persons.add(p4);
        persons.add(p3);
        persons.add(p1);
        persons.add(p2);
        //对集合进行去重
        List<Person> newPersons = removeRepeat(null,(o1,o2) -> o1.getId().compareTo(o2.getId()));
        //对集合排序
        newPersons.sort((o1,o2)->o1.getId().compareTo(o2.getId()));
        //对集合筛选
        newPersons.removeIf((o1)->o1.getId()<2);

        System.out.println(newPersons);
        persons.stream().forEach(o->System.out.println(o.getId()));
    }


    /**
     * 对集合进行去重,返回新集合
     * @param list 需要去重的List
     * @param c 比较器
     * @param <T>
     * @return 去重之后的List
     */
    public static<T> List<T> removeRepeat(List<T> list,Comparator<T> c) {
        if(list == null){
            return new ArrayList<T>();
        }

        Set<T> personSet = new TreeSet<T>(c);
        personSet.addAll(list);
        return new ArrayList<>(personSet);
    }

}

class Person {

    private Long id;

    private String name;

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}

