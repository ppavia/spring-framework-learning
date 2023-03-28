package ppa.spring.springframework.dataaccess.configuration;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ppa.spring.springframework.dataaccess.model.multitenant.MultitenantDataSource;
import ppa.spring.springframework.dataaccess.utils.StringUtils;

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
public class DbH2MultiTenantConfiguration implements ApplicationContextAware {

    private static final String TENANT_PATH = "tenants";

    private GenericApplicationContext applicationContext;

    @Value("${defaultTenant}")
    private String defaultTenant;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {

        Map<Object, Object> resolvedDataSources = new HashMap<>();
        try {
            URI tenantPropertiesFolder = ClassLoader.getSystemResource(TENANT_PATH).toURI();
            File[] files = Paths.get(tenantPropertiesFolder).toFile().listFiles();
            for (File propertyFile : files) {
                Properties tenantProperties = new Properties();
                DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();


                    tenantProperties.load(new FileInputStream(propertyFile));
                    String tenantId = tenantProperties.getProperty("name");
                    String prefix = "spring.datasource.%s.".formatted(tenantId);
                    String txName = "txManager%s".formatted(tenantId);


                DataSource targetDataSource = targetDataSource(tenantProperties.getProperty(prefix + "driver-class-name"), tenantProperties.getProperty(prefix + "url"));
                UserCredentialsDataSourceAdapter dataSource = dataSource(tenantProperties.getProperty(prefix + "username"), tenantProperties.getProperty(prefix + "password"), targetDataSource);
                LocalContainerEntityManagerFactoryBean entityManagerFactory = entityManagerFactory(dataSource, hibernateProperties(), jpaVendorAdapter(), "db-%s".formatted(tenantId));
                PlatformTransactionManager transactionManager = transactionManager(entityManagerFactory);

                this.applicationContext.registerBean("", DataSource.class, targetDataSource);
                this.applicationContext.registerBean("", UserCredentialsDataSourceAdapter.class, dataSource);
                this.applicationContext.registerBean("", LocalContainerEntityManagerFactoryBean.class, entityManagerFactory);
                this.applicationContext.registerBean("", PlatformTransactionManager.class, transactionManager);

                resolvedDataSources.put(tenantId, dataSourceBuilder.build());

            }
        } catch (IOException e) {
            throw new RuntimeException("Problem in tenant datasource: %s".formatted(e.getMessage()), e);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Problème in properties folder: %s".formatted(e.getMessage()), e);
        }

        AbstractRoutingDataSource dataSource = new MultitenantDataSource();
        dataSource.setDefaultTargetDataSource(resolvedDataSources.get(defaultTenant));
        dataSource.setTargetDataSources(resolvedDataSources);

        dataSource.afterPropertiesSet();
        return dataSource;
    }

    @Override public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (GenericApplicationContext) applicationContext;
    }

    public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactory ) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
        transactionManager.setJpaDialect(new HibernateJpaDialect());
        return transactionManager;
    }

    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSourceAdapter
            , Properties hibernateProperties
            , JpaVendorAdapter jpaVendorAdapter
            , String persistenceUnitName
    ) {
        final LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSourceAdapter);
        entityManagerFactory.setPackagesToScan("ppa.spring.domain.bean");
        entityManagerFactory.setPersistenceUnitName(persistenceUnitName);
        entityManagerFactory.setJpaProperties(hibernateProperties);
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        return entityManagerFactory;
    }

    public UserCredentialsDataSourceAdapter dataSource(String user, String password, DataSource targetDataSource) {
        final UserCredentialsDataSourceAdapter datasource = new UserCredentialsDataSourceAdapter();
        datasource.setCredentialsForCurrentThread(user, password);
        datasource.setTargetDataSource(targetDataSource);
        return datasource;
    }

    private DataSource targetDataSource(String driver, String databaseUrl) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(databaseUrl);
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
}