package springmvc2.com.springmvc.crud.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springmvc2.com.springmvc.crud.dao.EmployeeDao;
import springmvc2.com.springmvc.crud.entitys.Employee;

@Controller
public class SpringMVCTest {
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/testConversionServiceConverter")
    public String testConverter(@RequestParam("employee")Employee employee){
        System.out.println("save："+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
