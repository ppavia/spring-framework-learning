package ppa.spring.configuration.simpleautoconfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfiguration
public class SimpleAutoConfiguration {
    private static final Logger log = LoggerFactory.getLogger(SimpleAutoConfiguration.class);
    @Bean
    @ConditionalOnMissingBean
    public SimpleService simpleService() {
        log.info("SimpleService bean loaded");
        return new SimpleService();
    }
}
