package ppa.spring.pagination.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ppa.spring.pagination.domain.Country;

@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
    Page<Country> findPersonBy(Pageable name);
}
