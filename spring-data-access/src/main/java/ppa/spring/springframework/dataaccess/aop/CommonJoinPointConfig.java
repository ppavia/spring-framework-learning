package ppa.spring.springframework.dataaccess.aop;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class CommonJoinPointConfig {

    @Pointcut("execution(* ppa.spring.springframework.dataaccess.service.api.SimplePersonService.*(..))")
    public void beforeSimplePersonService () {
        // not implemented yet
    }
}
