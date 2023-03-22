package ppa.spring.transaction;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ppa.spring.domain.bean.Address;
import ppa.spring.domain.bean.Person;
import ppa.spring.repository.PersonRepository;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(properties = {"trace-sql.enabled=true"})
@ActiveProfiles("test")
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class PersonRepositoryTest {
    @Resource
    private PersonRepository personRepository;

    @Test
    void addNewPerson_Test() {
        Person person = new Person();
        Address address = new Address();

        address.setCity("Marseille");
        address.setNameStreet("Place de l'Opéra");
        address.setName("Public");
        address.setNumStreet("107");
        address.setZipCode("13000");

        person.setAge(34);
        person.setFirstName("Keny");
        person.setLastName("Arkana");
        person.addAddress(address);

        personRepository.save(person);

        Iterable<Person> persons = personRepository.findAll();
        long nbPersons = Stream.of(persons).count();

        assertTrue(nbPersons > 0);
    }
}
