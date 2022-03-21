package ppa.labs.springcoreproxy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ppa.labs.springcoreproxy.service.DefaultPersonService;
import ppa.labs.springcoreproxy.service.PersonService;

@Configuration
public class SpringCoreProxyConfiguration {

    @Bean
    public PersonService personService() {
        return new DefaultPersonService();
    }
}
