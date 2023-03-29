package ppa.spring.springframework.dataaccess.service;

import fr.assia.javacustomutils.string.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import ppa.spring.domain.bean.SimplePerson;
import ppa.spring.springframework.dataaccess.exception.ServiceException;
import ppa.spring.springframework.dataaccess.model.dto.SimplePersonDto;
import ppa.spring.springframework.dataaccess.model.multitenant.MultitenantDataSource;
import ppa.spring.springframework.dataaccess.model.multitenant.TenantContext;
import ppa.spring.springframework.dataaccess.model.repository.SimplePersonRepository;
import ppa.spring.springframework.dataaccess.service.api.SimplePersonService;

import java.util.List;
import java.util.Optional;

@Service
public class DefautlSimplePersonService implements SimplePersonService {
    private SimplePersonRepository simplePersonRepository;

    private String tenantId;

    public DefautlSimplePersonService(SimplePersonRepository simplePersonRepository) {
        this.simplePersonRepository = simplePersonRepository;
    }

    @Override public Optional<SimplePersonDto> getSimplePerson(Long id) {

        Optional<SimplePerson> simplePerson = simplePersonRepository.findById(id);
        if(simplePerson.isPresent()) {
            return Optional.of(mapSimplePerson(simplePerson.get()));
        }
        return Optional.empty();
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
