package ppa.spring.springframework.dataaccess.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = {"ppa.spring.domain.bean"})
public class DataAccessConfiguration {
}
