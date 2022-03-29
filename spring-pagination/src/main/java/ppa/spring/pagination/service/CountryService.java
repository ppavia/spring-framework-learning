package ppa.spring.pagination.service;

import ppa.spring.pagination.domain.Country;

import java.util.List;

public interface CountryService {
    Iterable<Country> getCountrys ();

    List<Country> getCountrys (int page, int size);
}
