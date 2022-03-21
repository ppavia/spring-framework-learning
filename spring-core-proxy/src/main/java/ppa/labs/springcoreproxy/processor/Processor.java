package ppa.labs.springcoreproxy.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ppa.labs.springcoreproxy.model.Person;
import ppa.labs.springcoreproxy.service.PersonService;

@Component
public class Processor {
    @Autowired
    private PersonService personService;

    public void process (Person person) {
        System.out.println(personService.getFullname(person));
    }
}
