package ppa.spring.springframework.di.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ppa.spring.springframework.di.services.PropertyGreetingServiceImpl;

class PropertyInjectionControllerTest {
    PropertyInjectionController controller;

    @BeforeEach
    void setUp() {
        controller = new PropertyInjectionController();
        controller.greetingService = new PropertyGreetingServiceImpl();
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}