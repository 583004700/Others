package zwb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller()
public class HelloWorldController {
    @RequestMapping("/index")
    public String helloWorld(HttpServletRequest request, Model model) {
        System.out.println(request);
        String viewArgValue = "Hello111就是这样啊";
        request.setAttribute("message", viewArgValue);
        return "index";
    }
}
