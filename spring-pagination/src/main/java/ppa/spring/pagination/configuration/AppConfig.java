package ppa.spring.pagination.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {
        "ppa.spring.pagination.repository"
        , "ppa.spring.pagination.service"
        , "ppa.spring.pagination.domain"
})
public class AppConfig {
}
