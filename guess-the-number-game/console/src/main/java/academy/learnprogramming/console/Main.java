package academy.learnprogramming.console;

import academy.learnprogramming.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Example of lombok (able to delete the logger inside the class)
@Slf4j
public class Main {
    // private static final Logger log = LoggerFactory.getLogger(Main.class);

    // Since we're not using beans.xml anymore
    // private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the number game");

        // Create context (container) using annotations
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(GameConfig.class);

        // Close context (container)
        // Prevent memory resource leaks
        // Singleton = single bean
        context.close();

    }
}
