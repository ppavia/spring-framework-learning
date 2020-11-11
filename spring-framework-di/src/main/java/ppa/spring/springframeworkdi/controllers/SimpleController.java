package ppa.spring.springframeworkdi.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class SimpleController {
    public String sayHello() {
        System.out.println("Hello world");
        return "Hi Folks";
    }
}
