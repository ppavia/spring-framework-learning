package ppa.spring.springframework.di.controllers;

import org.springframework.stereotype.Controller;
import ppa.spring.springframework.di.services.GreetingService;

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
