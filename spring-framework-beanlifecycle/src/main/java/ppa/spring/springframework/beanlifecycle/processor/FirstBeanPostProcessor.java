package ppa.spring.springframework.beanlifecycle.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class FirstBeanPostProcessor implements BeanPostProcessor {

    private ConfigurableBeanFactory configurableBeanFactory;

    @Autowired
    public FirstBeanPostProcessor(ConfigurableBeanFactory configurableBeanFactory) {
        this.configurableBeanFactory = configurableBeanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        printBeanName(bean, beanName, "postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        printBeanName(bean, beanName, "postProcessAfterInitialization");
        return bean;
    }

    private void printBeanName(Object bean, String beanName, String lifecycle) {
        if (beanName.equals("beanLifecycleGreetingService")) {

            System.out.println("BeanLifecycle ---- " + lifecycle);
            Arrays.stream(bean.getClass().getAnnotations()).forEach(annotation -> {
                System.out.println(annotation.annotationType());
            });
        }
    }
}