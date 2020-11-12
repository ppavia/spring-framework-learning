package ppa.spring.springframeworkprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ppa.spring.springframeworkprofile.controllers.I18nController;

@SpringBootApplication
public class SpringFramworkProfileMain {

    public static void main(String... args) {
        ApplicationContext ctx = SpringApplication.run(SpringFramworkProfileMain.class, args);

        System.out.println("------ Profile");
        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayHello());
    }
}
