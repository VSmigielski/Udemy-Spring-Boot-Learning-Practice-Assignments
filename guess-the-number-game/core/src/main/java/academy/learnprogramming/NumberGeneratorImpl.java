package academy.learnprogramming;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

// when you want to name a bean, you put it in parentheses&use quotes
// Removing the annotation because they will be found automatically
// @Component("generator")
@Component
public class NumberGeneratorImpl implements NumberGenerator {
    // Fields
    private final Random random = new Random();

    @Getter
    private final int maxNumber;
    @Getter
    private final int minNumber;

    // Constructors
    // Constructor is annotated
    @Autowired
    // Within the parameters, annotate the qualifiers
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    // Public methods
    @Override
    public int next() {
        // Example min = 5 max = 20 max-min = 15 -> range 0-15 + min -> 5-20
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }

}
