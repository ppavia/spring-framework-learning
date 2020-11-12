package ppa.spring.springframeworkdi.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import ppa.spring.springframeworkdi.services.GreetingService;

@Controller
public class ConstructorInjectionController {
    private final GreetingService greetingService;

    public ConstructorInjectionController(@Qualifier("controllerGreetingServiceImpl") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
