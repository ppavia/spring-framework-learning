package ppa.spring.springframeworkdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ppa.spring.springframeworkdi.controllers.SimpleController;

@SpringBootApplication
public class SpringFrameworkDiApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringFrameworkDiApplication.class, args);
        SimpleController simpleController = (SimpleController) ctx.getBean("simpleController");

        String greeting = simpleController.sayHello();

        System.out.println(greeting);
    }

}
