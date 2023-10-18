package ppa.spring.springframework.dataaccess.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ppa.spring.springframework.dataaccess.exception.TechnicalException;
import ppa.spring.springframework.dataaccess.model.multitenant.MultitenantDataSource;
import ppa.spring.springframework.dataaccess.model.multitenant.TenantFilter;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ConditionalOnProperty(
        value = "db.multitenant.enabled",
        havingValue = "true",
        matchIfMissing = false
)
public class DbH2MultiTenantConfiguration {

    private static final String TENANT_PATH = "tenants";

    @Bean("targetDataSources")
    public Map<Object, Object> targetDataSources () {
        Map<Object, Object> resolvedDataSources = new HashMap<>();
        try {
            URI tenantPropertiesFolder = ClassLoader.getSystemResource(TENANT_PATH).toURI();
            File[] files = Paths.get(tenantPropertiesFolder).toFile().listFiles();
            for (File propertyFile : files) {
                Properties tenantProperties = new Properties();
                loadProperties(propertyFile, tenantProperties);
                String tenantId = tenantProperties.getProperty("name");
                String prefix = "spring.datasource.%s.".formatted(tenantId);

                DataSource targetDataSource = targetDataSource(tenantProperties.getProperty(prefix + "driver-class-name"), tenantProperties.getProperty(prefix + "url"));
                UserCredentialsDataSourceAdapter dataSource = dataSource(tenantProperties.getProperty(prefix + "username"), tenantProperties.getProperty(prefix + "password"), targetDataSource);

                resolvedDataSources.put(tenantId, dataSource);
            }
        } catch (URISyntaxException e) {
            throw new TechnicalException("Problème in properties folder: %s".formatted(e.getMessage()), e);
        }
        return resolvedDataSources;
    }

    private void loadProperties(File propertyFile, Properties tenantProperties) {
        try (FileInputStream fis = new FileInputStream(propertyFile)) {
            tenantProperties.load(fis);
        } catch (IOException e) {
            throw new TechnicalException("Problem in tenant datasource: %s".formatted(e.getMessage()), e);
        }
    }

    @Value("${defaultTenant}")
    private String defaultTenant;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public MultitenantDataSource dataSource() {

        MultitenantDataSource dataSource = new MultitenantDataSource();
        dataSource.setTargetDataSources(targetDataSources());
        dataSource.setDefaultTargetDataSource(targetDataSources().get(defaultTenant));
        dataSource.setTargetDataSources(targetDataSources());

        dataSource.afterPropertiesSet();
        return dataSource;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", "false");
        hibernateProperties.setProperty("hibernate.readOnly", "true");
        return hibernateProperties;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.H2);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setShowSql(true);
        return jpaVendorAdapter;
    }

    @Bean
    public TenantFilter tenantFilter () {
        return new TenantFilter();
    }

    public static UserCredentialsDataSourceAdapter dataSource(String user, String password, DataSource targetDataSource) {
        final UserCredentialsDataSourceAdapter datasource = new UserCredentialsDataSourceAdapter();
        datasource.setUsername(user);
        datasource.setPassword(password);
        datasource.setCredentialsForCurrentThread(user, password);
        datasource.setTargetDataSource(targetDataSource);
        return datasource;
    }

    public static DataSource targetDataSource(String driver, String databaseUrl) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(databaseUrl);
        return dataSource;
    }
}