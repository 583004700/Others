package com.atguigu.springdata.test;

import com.atguigu.springdata.Person;
import com.atguigu.springdata.PersonRepository;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SpringDataTest {
    private ApplicationContext ctx;
    private PersonRepository personRepository = null;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        personRepository = ctx.getBean(PersonRepository.class);
    }

    @Test
    public void getNativeQuery(){
        long count = personRepository.getTotalCount();
        System.out.println(count);
    }

    @Test
    public void testQueryAnnotationLikeParam(){
//        List<Person> persons = personRepository.testQueryAnnotationLikeParam("%A%","%bb%");
//        System.out.println(persons.size());

        List<Person> persons = personRepository.testQueryAnnotationLikeParam("A","bb");
        System.out.println(persons.size());
    }

    @Test
    public void testQueryAnnotationParams2(){
        List<Person> persons = personRepository.testQueryAnnotationParams2("aa@qq.com","AA");
        System.out.println(persons);
    }

    @Test
    public void testQueryAnnotationParams1(){
        List<Person> persons = personRepository.testQueryAnnotationParams1("AA","aa@qq.com");
        System.out.println(persons);
    }

    @Test
    public void testQueryAnnotation(){
        Person person = personRepository.getMaxIdPerson();
        System.out.println(person);
    }

    @Test
    public void testKeyWords2(){
        List<Person> persons = personRepository.getByAddress_IdGreaterThan(1);
        System.out.println(persons.size());
    }

    @Test
    public void testKeyWords(){
        List<Person> persons = personRepository.getByLastNameStartingWithAndIdLessThan("B",10);
        System.out.println(persons.size());

        persons = personRepository.getByLastNameEndingWithAndIdLessThan("B",10);
        System.out.println(persons.size());

        persons = personRepository.getByEmailInOrBirthLessThan(Arrays.asList("AA","BB"),new Date());
        System.out.println(persons.size());
    }

    @Test
    public void testHelloWorldSpringData(){
        System.out.println(personRepository.getClass().getName());
        Person person = personRepository.getByLastName("AA");
        System.out.println(person);
    }

    @Test
    public void testDataSource(){
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource);
    }

    @Test
    public void testJpa(){

    }
}
