package ppa.labs.springcoreproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ppa.labs.springcoreproxy.model.Person;
import ppa.labs.springcoreproxy.processor.Processor;

@SpringBootApplication
public class SpringCoreProxyApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringCoreProxyApplication.class, args);
        Processor processor = context.getBean(Processor.class);
        Person person = new Person("DOE", "John");
        processor.process(person);

        System.out.println("end");
    }

}
