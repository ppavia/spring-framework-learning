package ppa.spring.springframework.di.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import ppa.spring.springframework.di.services.GreetingService;

@Controller
public class PropertyInjectionController {

    @Autowired
    @Qualifier("propertyGreetingServiceImpl")
    public GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
