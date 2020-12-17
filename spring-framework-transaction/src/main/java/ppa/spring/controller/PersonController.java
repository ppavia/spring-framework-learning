package ppa.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ppa.spring.domain.dto.PersonDTO;
import ppa.spring.responseentity.ResponseEntityWrapper;
import ppa.spring.service.PersonService;

@Controller
@RequestMapping(path = "/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public ResponseEntity<ResponseEntityWrapper<PersonDTO>> addNewPerson(
            @RequestBody PersonDTO personRequestMapper
    ) {
        return null;
    }
}
