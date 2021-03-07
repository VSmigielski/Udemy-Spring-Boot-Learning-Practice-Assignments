package academy.learnprogramming.service;

import academy.learnprogramming.service.DemoService;
import org.springframework.stereotype.Service;

// Stereotype Annotation
// For the service layer
// Typically holds the business logic/processes data
@Service

public class DemoServiceImpl implements DemoService {
    @Override
    public String getHelloMessage(String user) {
        return "Hello " + user;
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to this Demo application";
    }
}
