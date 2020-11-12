package ppa.spring.springframeworkprofile.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ppa.spring.springframeworkdi.services.GreetingService;

@Profile("En")
@Service("i18nService")
public class I18nEnGreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World -- En";
    }
}
