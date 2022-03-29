package ppa.spring.pagination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ppa.spring.pagination.domain.Country;
import ppa.spring.pagination.repository.CountryRepository;

import java.util.List;

@Service
public class DefaultCountryService implements CountryService {

    private CountryRepository countryRepository;

    @Autowired
    public DefaultCountryService (CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Transactional(readOnly = true)
    @Override public Iterable<Country> getCountrys() {
        return countryRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override public List<Country> getCountrys(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Country> countrys = countryRepository.findAll(pageable);
        return countrys.toList();
    }
}
