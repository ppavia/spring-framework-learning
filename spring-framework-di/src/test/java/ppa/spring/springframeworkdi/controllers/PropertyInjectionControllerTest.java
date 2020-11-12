package ppa.spring.springframeworkdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ppa.spring.springframeworkdi.services.PropertyGreetingServiceImpl;

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