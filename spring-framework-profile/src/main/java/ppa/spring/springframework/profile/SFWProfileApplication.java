package ppa.spring.springframework.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ppa.spring.springframework.profile.controllers.I18nController;

@SpringBootApplication
public class SFWProfileApplication {

    public static void main(String... args) {
        ApplicationContext ctx = SpringApplication.run(SFWProfileApplication.class, args);

        System.out.println("------ Profile");
        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayHello());
    }
}
