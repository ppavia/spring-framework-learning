import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ppa.spring.pagination.configuration.AppConfig;
import ppa.spring.pagination.configuration.JpaConfiguration;
import ppa.spring.pagination.domain.Country;
import ppa.spring.pagination.service.CountryService;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        AppConfig.class,
        JpaConfiguration.class
})
public class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @Test
    void testGetCountries () {
        Iterable<Country> countries = countryService.getCountrys();
        Assertions.assertTrue(countries.iterator().hasNext());
    }
}
