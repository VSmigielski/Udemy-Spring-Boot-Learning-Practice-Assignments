package academy.learnprogramming;

import org.springframework.stereotype.Component;

import java.util.Random;

// when you want to name a bean, you put it in parentheses&use quotes
// Removing the annotation because they will be found automatically
// @Component("generator")
public class NumberGeneratorImpl implements NumberGenerator {
    // Fields
    private final Random random = new Random();

    private int maxNumber = 100;

    // Public methods
    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
