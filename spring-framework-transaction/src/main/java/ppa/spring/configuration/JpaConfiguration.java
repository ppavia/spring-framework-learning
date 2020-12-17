package ppa.spring.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ppa.spring.logger.LoggerTools;

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
//        LoggerTools.logEnv(this.logger, this.environment);
//        return DataSourceBuilder.create()
//                .url(environment.getProperty("spring.datasource.url"))
//            .driverClassName(environment.getProperty("spring.datasource.driver-class-name"))
//                .username(environment.getProperty("spring.datasource.username"))
//                .password(environment.getProperty("spring.datasource.password"))
//                .build();
//    }

//    @Bean
//    @Profile("dev")
//    public DataSource DataSourceProxy() {
//        LoggerTools.logEnv(this.logger, this.environment);
//        DataSource dataSource = DataSourceBuilder.create()
//                .url(environment.getProperty("spring.datasource.url"))
//                .driverClassName(environment.getProperty("spring.datasource.driver-class-name"))
//                .username(environment.getProperty("spring.datasource.username"))
//                .password(environment.getProperty("spring.datasource.password"))
//                .build();
//        return ProxyDataSourceBuilder.create(dataSource)
//                .logQueryBySlf4j(SLF4JLogLevel.INFO)
//                .build();
//    }
}