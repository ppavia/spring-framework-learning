package ppa.spring.domain.mapper;

import org.mapstruct.Mapper;
import ppa.spring.domain.bean.Person;
import ppa.spring.domain.dto.PersonDTO;

@Mapper
public interface PersonMapper {
    PersonDTO toPersonDTO(Person person);

    Person toPerson(PersonDTO personDTO);
}
