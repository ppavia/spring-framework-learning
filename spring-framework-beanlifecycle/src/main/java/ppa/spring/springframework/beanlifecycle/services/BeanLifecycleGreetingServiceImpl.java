package ppa.spring.springframework.beanlifecycle.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.stereotype.Service;
import ppa.spring.springframework.beanlifecycle.processor.BeanLifecycle;

@Service("beanLifecycleGreetingService")
@BeanLifecycle
public class BeanLifecycleGreetingServiceImpl implements
        BeanLifecycleGreetingService,
        InitializingBean,
        DisposableBean,
        BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware,
        BeanClassLoaderAware,
        ApplicationEventPublisherAware,
        LoadTimeWeaverAware,
        MessageSourceAware,
        ResourceLoaderAware {

    private static int countLiveCycleStep;

    @Override
    public String sayHello() {
        return "Hello World -- BeanLifecycle Service";
    }

    @PostConstruct
    public void init() {
        System.out.println(++countLiveCycleStep + " " + "BeanLifecycle ---- custom init");
    }

    @PreDestroy
    public void customDestroy() {
        System.out.println(++countLiveCycleStep + " " + "BeanLifecycle ---- custom destroy");
    }

    // From InitializingBean
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(++countLiveCycleStep + " " + "BeanLifecycle ---- afterPropertiesSet");
    }

    // From DisposableBean
    @Override
    public void destroy() throws Exception {
        System.out.println(++countLiveCycleStep + " " + "BeanLifecycle ---- destroy");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println(++countLiveCycleStep + " " + "BeanLifecycle ---- setBeanName");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(++countLiveCycleStep + " " + "BeanLifecycle ---- setBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(++countLiveCycleStep + " " + "BeanLifecycle ---- setApplicationContext");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println(++countLiveCycleStep + " " + "BeanLifecycle ---- setBeanClassLoader");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println(++countLiveCycleStep + " " + "BeanLifecycle ---- setApplicationEventPublisher");
    }

    @Override
    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
        System.out.println(++countLiveCycleStep + " " + "BeanLifecycle ---- setLoadTimeWeaver");
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println(++countLiveCycleStep + " " + "BeanLifecycle ---- setMessageSource");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println(++countLiveCycleStep + " " + "BeanLifecycle ---- setResourceLoader");
    }
}
