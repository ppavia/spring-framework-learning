package ppa.spring.springframeworkdi.controllers;

import org.springframework.stereotype.Controller;
import ppa.spring.springframeworkdi.services.GreetingService;

@Controller
public class SimpleController {

    private final GreetingService greetingService;

    public SimpleController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
