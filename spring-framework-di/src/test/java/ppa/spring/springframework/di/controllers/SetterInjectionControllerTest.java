package ppa.spring.springframework.di.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ppa.spring.springframework.di.services.PropertyGreetingServiceImpl;

class SetterInjectionControllerTest {

    SetterInjectionController setterInjectionController;

    @BeforeEach
    void setUp() {
        setterInjectionController = new SetterInjectionController();
        setterInjectionController.setGreetingService(new PropertyGreetingServiceImpl());
    }

    @Test
    void getGreeting() {
        System.out.println(setterInjectionController.getGreeting());
    }
}