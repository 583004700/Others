package springmvc1.com.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorld {

    @RequestMapping("testPathVariable/{id}")
    public String testPathVariable(@PathVariable(value="id") Integer id){
        System.out.println("testPathVariable"+id);
        return "success";
    }

    /**
     * ant风格的路径
     * @return
     */
    @RequestMapping("/testAntPath/*/abc")
    public String testAntPath(){
        System.out.println("testAntPath");
        return "success";
    }

    @RequestMapping(value = "/helloworld")
    public String hello(){
        System.out.println("hello world");
        return "success";
    }

    @RequestMapping(value = "/testMethod",method = RequestMethod.POST)
    public String testMethod(){
        System.out.println("testMethod");
        return "success";
    }

    /**
     * 请求必须包含参数username，如果包含了age，则值不等于10
     * 请求头Accept-Language必须是zh-CN,zh;q=0.8
     * @return
     */
    @RequestMapping(value = "testParamsAndHeaders", params = {"username","age!=10"},headers = "Accept-Language=zh-CN,zh;q=0.8")
    public String testParamsAndHeaders(){
        System.out.println("testParamsAndHeaders");
        return "success";
    }
}
