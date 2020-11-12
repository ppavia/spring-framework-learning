package ppa.spring.springframeworkdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import ppa.spring.springframeworkdi.services.GreetingService;

@Controller
public class SetterInjectionController {
    private GreetingService greetingService;

    @Autowired
    public void setGreetingService(@Qualifier("setterGreetingServiceImpl") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
