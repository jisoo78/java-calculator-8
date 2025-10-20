package calculator;

import java.util.Arrays;

public class Calculator {
    public int add(String numberString) {

        String separator = ",|:";
        String[] numbers = numberString.split(separator);

        int sum = Arrays.stream(numbers)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .sum();

        return sum;
    }
}
