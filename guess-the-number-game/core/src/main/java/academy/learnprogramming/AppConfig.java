package academy.learnprogramming;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Usually these classes contain bean methods
// Bean methods - Methods that represent a bean definition (producer methods, configure and return a bean)
//
// Internally processed as a component
@Configuration
// Configures component scanning, best practice to annotate the basePackages
@ComponentScan(basePackages = "academy.learnprogramming")
public class AppConfig {
    // Bean Methods
    @Bean
    public NumberGenerator numberGenerator() {
        return new NumberGeneratorImpl();
    }

    @Bean
    public Game game() {
        return new GameImpl();
    }

    @Bean
    public MessageGenerator messageGenerator() {
        return new MessageGeneratorImpl();
    }
}
