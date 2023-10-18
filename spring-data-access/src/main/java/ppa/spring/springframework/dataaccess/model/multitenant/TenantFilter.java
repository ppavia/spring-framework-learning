package ppa.spring.springframework.dataaccess.model.multitenant;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Order(1)
public class TenantFilter implements Filter {

    @Autowired
    MultitenantDataSource dataSource;
    @Override public void doFilter(
            ServletRequest request
            , ServletResponse response
            , FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String tenantName = req.getHeader("X-TenantID");
        if(tenantName != null) {
            dataSource.addTargetDataSources(tenantName);
            TenantContext.setCurrentTenant(tenantName);
        }

        try {
            chain.doFilter(request, response);
        } finally {
            TenantContext.clear();
        }
    }
}
