package com.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class ChartController {
    @PostMapping("/")
    String home(@RequestBody User user) {
        System.out.println(user.getUsername());
        return "Hello World!";
    }

    @PostMapping("/one")
    String homeone(@RequestParam String username) {
        System.out.println(username);
        return "Hello World!";
    }

    @GetMapping("/two")
    String hometwo(@RequestParam String username) {
        System.out.println(username);
        return "Hello World!";
    }

    @RequestMapping("/register/{username}/{pwd}")
    String index(@PathVariable String username, @PathVariable String pwd, @RequestBody String k) {
        System.out.println(username);
        System.out.println(pwd);
        System.out.println(k);
        return "q";
    }
}
