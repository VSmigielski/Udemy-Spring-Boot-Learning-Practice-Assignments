package academy.learnprogramming.service;

import org.springframework.stereotype.Service;

@Service
public interface DemoService {
    String getHelloMessage(String user);
    String getWelcomeMessage();
}
