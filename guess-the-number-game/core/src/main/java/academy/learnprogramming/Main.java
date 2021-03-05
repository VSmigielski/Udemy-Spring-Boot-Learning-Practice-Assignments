package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the number game");

        // Create context first (container)
        ConfigurableApplicationContext context
                = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        // Get numberGenerator bean from context (container)
        NumberGenerator numberGenerator
                = context.getBean("numberGenerator", NumberGenerator.class);

        // Call method next() to get a random number
        int number = numberGenerator.next();

        // Log generated number
        log.info("number = {}", number);

        // Get the game bean from context (container)
        // Can retrieve bean in many ways, this one is overloaded
        Game game = context.getBean(Game.class);

        // Call reset method
        // Initializes class itself, but we can configure it to call automatically (prone to errors)
        // add this to first bean area: init-method="reset"
        // game.reset();

        // Close context (container)
        // Prevent memory resource leaks
        // Singleton = single bean
        context.close();



    }
}
