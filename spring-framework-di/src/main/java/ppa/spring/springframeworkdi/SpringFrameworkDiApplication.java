package ppa.spring.springframeworkdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ppa.spring.springframeworkdi.controllers.ConstructorInjectionController;
import ppa.spring.springframeworkdi.controllers.PropertyInjectionController;
import ppa.spring.springframeworkdi.controllers.SetterInjectionController;
import ppa.spring.springframeworkdi.controllers.SimpleController;

@SpringBootApplication
public class SpringFrameworkDiApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringFrameworkDiApplication.class, args);

        System.out.println("----------- Primary Bean");
        lunchSimpleController(ctx);

        System.out.println("----------- Property");
        lunchPropertyInjectionController(ctx);

        System.out.println("----------- Setter");
        lunchSetterInjectionController(ctx);

        System.out.println("----------- Controller");
        lunchConstructorInjectionController(ctx);
    }

    private static void lunchSimpleController(ApplicationContext ctx) {
        SimpleController simpleController = (SimpleController) ctx.getBean("simpleController");
        String greeting = simpleController.sayHello();
        System.out.println(greeting);
    }

    private static void lunchPropertyInjectionController(ApplicationContext ctx) {
        PropertyInjectionController propertyInjectionController = (PropertyInjectionController) ctx.getBean("propertyInjectionController");
        System.out.println(propertyInjectionController.getGreeting());
    }

    private static void lunchSetterInjectionController(ApplicationContext ctx) {
        SetterInjectionController setterInjectionController = (SetterInjectionController) ctx.getBean("setterInjectionController");
        System.out.println(setterInjectionController.getGreeting());
    }

    private static void lunchConstructorInjectionController(ApplicationContext ctx) {
        ConstructorInjectionController constructorInjectionController = (ConstructorInjectionController) ctx.getBean("constructorInjectionController");
        System.out.println(constructorInjectionController.getGreeting());
    }
}
