package springmvc2.com.springmvc.crud.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import springmvc2.com.springmvc.crud.dao.EmployeeDao;
import springmvc2.com.springmvc.crud.entitys.Employee;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

@Controller
public class SpringMVCTest {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @RequestMapping("/testFileUpload")
    public String testFileUpload(@RequestParam("desc") String desc, @RequestParam("file")MultipartFile file){
        try {
            System.out.println("desc："+desc);
            System.out.println("OriginalFilename："+file.getOriginalFilename());
            System.out.println("InputStream："+file.getInputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "success";
    }

    @RequestMapping("/i18n")
    public String testI18n(Locale locale){
        String val = messageSource.getMessage("i18n.user",null, locale);
        System.out.println(val);
        return "i18n";
    }

    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session){
        ResponseEntity<byte[]> response = null;
        try {
            byte[] body = null;
            ServletContext servletContext = session.getServletContext();
            InputStream in = servletContext.getResourceAsStream("/files/abc.txt");
            body = new byte[in.available()];
            in.read(body);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment;filename=abc.txt");
            HttpStatus statusCode = HttpStatus.OK;
            response = new ResponseEntity<byte[]>(body, headers, statusCode);
        }catch (Exception e){
            e.printStackTrace();
        }

        return response;
    }

    @ResponseBody
    @RequestMapping("/testHttpMessageConverter")
    public String testHttpMessageConverter(@RequestBody String body){
        System.out.println(body);
        return "helloWorld!" + new Date();
    }

    @ResponseBody
    @RequestMapping("/testJson")
    public Collection<Employee> testJson(){
        return employeeDao.getAll();
    }

    @RequestMapping("/testConversionServiceConverter")
    public String testConverter(@RequestParam("employee")Employee employee){
        System.out.println("save："+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
