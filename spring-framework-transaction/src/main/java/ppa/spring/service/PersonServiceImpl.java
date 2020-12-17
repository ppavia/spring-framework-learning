package ppa.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ppa.spring.domain.bean.Person;
import ppa.spring.domain.dto.PersonDTO;
import ppa.spring.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public PersonDTO findPersonById(String id) {
        Person person;
        return null;
    }

    @Override
    public PersonDTO findPersonByName(String fullName) {
        return null;
    }

    @Override
    public Person addNewPerson(PersonDTO personRequestMapper) {
        return null;
    }
}
