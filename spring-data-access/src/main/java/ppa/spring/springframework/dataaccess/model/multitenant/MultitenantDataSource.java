package ppa.spring.springframework.dataaccess.model.multitenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import ppa.spring.springframework.dataaccess.configuration.DbH2MultiTenantConfiguration;

import javax.sql.DataSource;
import java.util.Map;

public class MultitenantDataSource extends AbstractRoutingDataSource {

    @Autowired
    private Map<Object, Object> targetDataSources;

    private String url = "jdbc:h2:tcp://localhost/C:/DEV/H2/db/$s;DB_CLOSE_DELAY=-1";
    private String driver = "org.h2.Driver";
    private String username = "sa";
    private String password = "sa";

    @Override protected Object determineCurrentLookupKey() {
        return TenantContext.getCurrentTenant();
    }

    public void addTargetDataSources(String tenantId) {
        targetDataSources.computeIfAbsent(tenantId, id -> {
            String tenantUrl = url.formatted(tenantId.toUpperCase());
            DataSource targetDataSource = DbH2MultiTenantConfiguration.targetDataSource(driver, tenantUrl);
            UserCredentialsDataSourceAdapter dataSource = DbH2MultiTenantConfiguration.dataSource(
                    username
                    , password
                    , targetDataSource
            );
            this.setDefaultTargetDataSource(dataSource);
            targetDataSources.put(tenantId, dataSource);
            return tenantUrl;
        });
        this.setTargetDataSources(targetDataSources);
    }
}