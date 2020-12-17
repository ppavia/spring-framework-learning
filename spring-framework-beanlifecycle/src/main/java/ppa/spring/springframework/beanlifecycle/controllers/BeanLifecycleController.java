package ppa.spring.springframework.beanlifecycle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ppa.spring.springframework.beanlifecycle.services.BeanLifecycleGreetingService;

@Controller
public class BeanLifecycleController {
    private final BeanLifecycleGreetingService beanLifecycleGreetingService;

    @Autowired
    public BeanLifecycleController(BeanLifecycleGreetingService beanLifecycleGreetingService) {
        System.out.println("BeanLifecycle ---- BeanLifecycleController");
        this.beanLifecycleGreetingService = beanLifecycleGreetingService;
    }

    public String getGreeting() {
        return this.beanLifecycleGreetingService.sayHello();
    }
}
