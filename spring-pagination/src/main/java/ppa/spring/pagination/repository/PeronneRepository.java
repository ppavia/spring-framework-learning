package ppa.spring.pagination.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ppa.spring.domain.bean.Person;

@Repository
public interface PeronneRepository extends PagingAndSortingRepository<Person, Long> {
    Page<Person> findPersonBy(Pageable name);
}
