package ppa.spring.repository;

import org.springframework.data.repository.CrudRepository;
import ppa.spring.domain.bean.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
