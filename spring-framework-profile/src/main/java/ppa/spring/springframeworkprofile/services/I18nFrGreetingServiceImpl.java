package ppa.spring.springframeworkprofile.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ppa.spring.springframeworkdi.services.GreetingService;

@Profile("Fr")
@Service("i18nService")
public class I18nFrGreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Salut Monde -- Fr";
    }
}
