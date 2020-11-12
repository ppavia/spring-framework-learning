package ppa.spring.springframeworkdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ppa.spring.springframeworkdi.services.PropertyGreetingServiceImpl;

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