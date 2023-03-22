package ppa.spring.springframework.dataaccess.service.api;

import ppa.spring.springframework.dataaccess.exception.ServiceException;
import ppa.spring.springframework.dataaccess.model.dto.SimplePersonDto;

import java.util.List;
import java.util.Optional;

public interface SimplePersonService {

    Optional<SimplePersonDto> getSimplePerson(Long id) throws ServiceException;

    SimplePersonDto getSimplePerson(String firstName, String lastName) throws ServiceException;

    List<SimplePersonDto> getSimplePersons(String firstName) throws ServiceException;
}