package ppa.spring.springframework.di.services;

import org.springframework.stereotype.Service;

@Service
public class ControllerGreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World -- Controller";
    }
}
