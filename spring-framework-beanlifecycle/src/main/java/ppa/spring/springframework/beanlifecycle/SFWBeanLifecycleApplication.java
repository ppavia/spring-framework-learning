package ppa.spring.springframework.beanlifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ppa.spring.springframework.beanlifecycle.controllers.BeanLifecycleController;

@SpringBootApplication
public class SFWBeanLifecycleApplication {
    public static void main(String... args) {
        ApplicationContext ctx = SpringApplication.run(SFWBeanLifecycleApplication.class, args);

        BeanLifecycleController beanLifecycleController = (BeanLifecycleController) ctx.getBean("beanLifecycleController");
        System.out.println(beanLifecycleController.getGreeting());

    }
}
