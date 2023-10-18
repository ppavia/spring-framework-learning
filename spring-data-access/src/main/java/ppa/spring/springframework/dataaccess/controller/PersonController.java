package ppa.spring.springframework.dataaccess.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ppa.spring.configuration.simpleautoconfiguration.SimpleService;
import ppa.spring.springframework.dataaccess.exception.RestException;
import ppa.spring.springframework.dataaccess.exception.ServiceException;
import ppa.spring.springframework.dataaccess.model.dto.RestResponse;
import ppa.spring.springframework.dataaccess.model.dto.SimplePersonDto;
import ppa.spring.springframework.dataaccess.service.api.SimplePersonService;
import ppa.spring.springframework.dataaccess.utils.HttpResponseUtil;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private SimplePersonService simplePersonService;

    private SimpleService simpleService;

    public PersonController(SimplePersonService simplePersonService, SimpleService simpleService) {
        this.simplePersonService = simplePersonService;
        this.simpleService = simpleService;
    }

    @GetMapping(value = "/{firstName}/{lastName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponse<SimplePersonDto>> person(
            HttpServletRequest request
            , @PathVariable("firstName") String firstName
            , @PathVariable("lastName") String lastName
    ) throws RestException {
        this.simpleService.helloWord();
        SimplePersonDto simplePerson = null;
        try {
            simplePerson = simplePersonService.getSimplePerson(firstName, lastName);
        } catch (ServiceException e) {
            throw new RestException(e.getMessage(), HttpStatus.NOT_FOUND, e);
        }
        return HttpResponseUtil.buildRestResponse(simplePerson, HttpStatus.OK.name(), request.getRequestURI());
    }

    @GetMapping(value = "/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponse<List<SimplePersonDto>>> person(
            HttpServletRequest request
            , @PathVariable("firstName") String firstName
    ) throws RestException {
        List<SimplePersonDto> simplePersons = null;
        try {
            simplePersons = simplePersonService.getSimplePersons(firstName);
        } catch (ServiceException e) {
            throw new RestException(e.getMessage(), HttpStatus.NOT_FOUND, e);
        }
        return HttpResponseUtil.buildRestResponse(simplePersons, HttpStatus.OK.name(), request.getRequestURI());
    }

    @GetMapping(value = "/AV", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimplePersonDto> person(
            HttpServletRequest request
    ) throws RestException {
       String firstName = "Adrien";
       String lastName = "Vergnaud";
        SimplePersonDto simplePerson = null;
        try {
            simplePerson = simplePersonService.getSimplePerson(firstName, lastName);
        } catch (ServiceException e) {
            throw new RestException(e.getMessage(), HttpStatus.NOT_FOUND, e);
        }
        return HttpResponseUtil.buildRestResponse(simplePerson);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SimplePersonDto>> persons(
            HttpServletRequest request
    ) throws RestException {
        List<SimplePersonDto> simplePersons = null;
        try {
            simplePersons = simplePersonService.getPersons();
        } catch (ServiceException e) {
            throw new RestException(e.getMessage(), HttpStatus.NOT_FOUND, e);
        }
        return HttpResponseUtil.buildRestResponse(simplePersons);
    }

    @GetMapping("/400")
    public ResponseEntity<Void> noPerson() throws RestException {
        throw new RestException("a bad request", HttpStatus.NOT_FOUND);
    }

    @PutMapping (
            consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponse<SimplePersonDto>> createNewPerson(
            HttpServletRequest request
            , @RequestBody SimplePersonDto simplePersonDto
    )  throws RestException {
        try {
            simplePersonDto = simplePersonService.addSimplePerson(simplePersonDto, request.getHeader("X-TenantID"));
        } catch (ServiceException e) {
            throw new RestException(e.getMessage(), HttpStatus.NOT_FOUND, e);
        }
        return HttpResponseUtil.buildRestResponse(simplePersonDto, HttpStatus.OK.name(), request.getRequestURI());
    }
}
