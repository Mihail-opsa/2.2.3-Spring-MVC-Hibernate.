package web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "TEST WORKS! Spring MVC is working";
    }

    @GetMapping("/simple")
    @ResponseBody
    public String simple() {
        return "SIMPLE TEST - No Thymeleaf";
    }
}