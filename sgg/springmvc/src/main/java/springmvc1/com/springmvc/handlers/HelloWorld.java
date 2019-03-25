package springmvc1.com.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorld {
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
     * @return
     */
    @RequestMapping(value = "testParamsAndHeaders", params = {"username","age!=10"})
    public String testParamsAndHeaders(){
        System.out.println("testParamsAndHeaders");
        return "success";
    }
}
