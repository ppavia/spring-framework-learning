package ppa.spring.springframework.beanlifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class SFWBeanLifecycleMain {
    public static void main (String... args) {
        ApplicationContext ctx = SpringApplication.run(SFWBeanLifecycleMain.class, args);
    }
}
