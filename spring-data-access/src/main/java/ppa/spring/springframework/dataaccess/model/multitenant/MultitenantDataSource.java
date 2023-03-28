package ppa.spring.springframework.dataaccess.model.multitenant;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultitenantDataSource extends AbstractRoutingDataSource {

    @Override protected Object determineCurrentLookupKey() {
        return TenantContext.getCurrentTenant();
    }
}
