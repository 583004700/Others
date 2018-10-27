package org.mybatis.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class MybatisTest {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws Exception{
        String resource = "org/mybatis/example/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //第一个参数为mapper的namespace和id
        Employee employee = sqlSession.selectOne("org.mybatis.example.EmployeeMapper."+"selectEmp",1);
        System.out.println(employee.getEmail());
        sqlSession.close();
    }

    @Test
    public void test2() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //第一个参数为mapper的namespace和id
        Employee employee = sqlSession.getMapper(EmployeeMapper.class).getEmpById(1);
        System.out.println(employee.getEmail());
        sqlSession.close();
    }
}
