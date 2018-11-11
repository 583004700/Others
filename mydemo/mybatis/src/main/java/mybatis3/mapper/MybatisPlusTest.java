package mybatis3.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class MybatisPlusTest {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws Exception{
        String resource = "mybatis3/mapper/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //此时的sqlSessionFactory是DefaultSqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testGetEmpById(){
        SqlSession session = sqlSessionFactory.openSession();
        EmployeeMapperPlus mapperPlus = session.getMapper(EmployeeMapperPlus.class);
        Employee employee = mapperPlus.getEmpById(1);
        System.out.println(employee.getLastName());
        System.out.println(employee.getEmail());
    }

    @Test
    public void testGetEmpAndDept(){
        SqlSession session = sqlSessionFactory.openSession();
        EmployeeMapperPlus mapperPlus = session.getMapper(EmployeeMapperPlus.class);
        Employee employee = mapperPlus.getEmpAndDept(1);
        System.out.println(employee.getDepartment().getDepartmentName());
    }

    @Test
    public void testGetEmpByIdStep(){
        SqlSession session = sqlSessionFactory.openSession();
        EmployeeMapperPlus mapperPlus = session.getMapper(EmployeeMapperPlus.class);
        Employee employee = mapperPlus.getEmpByIdStep(1);
        System.out.println(employee.getDepartment().getDepartmentName());
        System.out.println(employee.getDepartment().getId());
    }

}
