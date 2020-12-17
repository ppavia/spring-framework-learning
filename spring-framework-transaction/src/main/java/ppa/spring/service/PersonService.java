package ppa.spring.service;

import ppa.spring.domain.dto.PersonDTO;
import ppa.spring.domain.bean.Person;

public interface PersonService {

    PersonDTO findPersonById(String id);

    PersonDTO findPersonByName(String fullName);

    Person addNewPerson(PersonDTO personRequestMapper);
}
