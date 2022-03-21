package ppa.labs.springcoreproxy.service;

import ppa.labs.springcoreproxy.model.Person;

public interface PersonService {

    String getFullname(Person person);

    String getAge(Person person);
}
