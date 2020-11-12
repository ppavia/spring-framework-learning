package ppa.spring.springframework.di.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ppa.spring.springframework.di.services.PropertyGreetingServiceImpl;

class ConstructorInjectionControllerTest {

    ConstructorInjectionController controller;

    @BeforeEach
    void setUp() {
        controller = new ConstructorInjectionController(new PropertyGreetingServiceImpl());
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}