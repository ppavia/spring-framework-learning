package ppa.spring.springframework.dataaccess.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ppa.spring.domain.bean.SimplePerson;
import ppa.spring.springframework.dataaccess.exception.ServiceException;
import ppa.spring.springframework.dataaccess.model.dto.SimplePersonDto;
import ppa.spring.springframework.dataaccess.model.repository.SimplePersonRepository;
import ppa.spring.springframework.dataaccess.service.api.SimplePersonService;

import java.util.List;
import java.util.Optional;

@Service
public class DefautlSimplePersonService implements SimplePersonService {
    private final SimplePersonRepository simplePersonRepository;

    private String tenantId;

    public DefautlSimplePersonService(SimplePersonRepository simplePersonRepository) {
        this.simplePersonRepository = simplePersonRepository;
    }

    @Override public Optional<SimplePersonDto> getSimplePerson(Long id) {

        Optional<SimplePerson> simplePerson = simplePersonRepository.findById(id);
        return simplePerson.map(this::mapSimplePerson);
    }

    @Override public SimplePersonDto getSimplePerson(String firstName, String lastName) throws ServiceException {
        SimplePerson simplePerson = simplePersonRepository.findByFirstNameAndLastName(firstName, lastName);
        if(simplePerson == null) {
            throw new ServiceException(String.format("la personne [%s,%s] n'a pas été trouvée.", firstName, lastName));
        }

        return mapSimplePerson(simplePerson);
    }

    @Transactional
    @Override public List<SimplePersonDto> getSimplePersons(String firstName) throws ServiceException {
        List<SimplePerson> simplePersons = simplePersonRepository.findByFirstName(firstName);
        return simplePersons.stream()
                .map(this::mapSimplePerson)
                .toList();
    }

    @Override public SimplePersonDto addSimplePerson(SimplePersonDto simplePersonDto, String tenantId) throws ServiceException {
        SimplePerson simplePerson = simplePersonRepository.save(mapSimplePersonDto(simplePersonDto));
        return mapSimplePerson(simplePerson);
    }

    private SimplePersonDto mapSimplePerson (SimplePerson simplePerson) {
        SimplePersonDto simplePersonDto = new SimplePersonDto();

        simplePersonDto.setId(simplePerson.getId());
        simplePersonDto.setFirstName(simplePerson.getFirstName());
        simplePersonDto.setLastName(simplePerson.getLastName());

        return simplePersonDto;
    }
    private SimplePerson mapSimplePersonDto (SimplePersonDto simplePersonDto) {
        SimplePerson simplePerson = new SimplePerson();

        // avoids NotNull check on entity
        if (simplePersonDto.getId() != null) {
            simplePerson.setId(simplePersonDto.getId());
        }
        simplePerson.setFirstName(simplePersonDto.getFirstName());
        simplePerson.setLastName(simplePersonDto.getLastName());

        return simplePerson;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
