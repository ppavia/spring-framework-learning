package ppa.spring.configuration;

import net.ttddyy.dsproxy.listener.logging.SLF4JLogLevel;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
//@EnableJpaRepositories(basePackages = "ppa.spring.repository")
//@EnableTransactionManagement
public class JpaConfiguration {
    private final Logger logger = LoggerFactory.getLogger(JpaConfiguration.class);

    private final Environment environment;

    @Autowired
    public JpaConfiguration(Environment environment) {
        this.environment = environment;
    }

//    @Bean
//    @Profile("prod")
//    public DataSource mysqlDataSource() {
//        return DataSourceBuilder.create()
//                .url(environment.getProperty("spring.datasource.url"))
//            .driverClassName(environment.getProperty("spring.datasource.driver-class-name"))
//                .username(environment.getProperty("spring.datasource.username"))
//                .password(environment.getProperty("spring.datasource.password"))
//                .build();
//    }

    @Bean
    @Profile("dev")
    public DataSource DataSourceProxy() {
        DataSource dataSource = DataSourceBuilder.create()
                .url(environment.getProperty("spring.datasource.url"))
                .driverClassName(environment.getProperty("spring.datasource.driver-class-name"))
                .username(environment.getProperty("spring.datasource.username"))
                .password(environment.getProperty("spring.datasource.password"))
                .build();
        return ProxyDataSourceBuilder.create(dataSource)
                .logQueryBySlf4j(SLF4JLogLevel.INFO)
                .build();
    }
}