package ppa.labs.springcoreproxy.service;

import ppa.labs.springcoreproxy.model.Person;

public class DefaultPersonService implements PersonService {
    @Override
    public String getFullname(Person person) {
        return person.getFirstName() + " " + person.getLastName();
    }

    @Override
    public String getAge(Person person) {
        return null;
    }
}
