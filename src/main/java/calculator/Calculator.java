package calculator;

import java.util.Arrays;

public class Calculator {
    public int add(String numberString) {

        String separator = ",|;";

        if (numberString.startsWith("//")) {
            int newlineIndex = numberString.indexOf("\n");

            if (newlineIndex == -1) {
                newlineIndex = numberString.indexOf("\\n");
            }

            if (newlineIndex != -1) {
                separator = numberString.substring(2, newlineIndex);

                if (numberString.charAt(newlineIndex) == '\\') {
                    numberString = numberString.substring(newlineIndex + 2);
                }
            }
        }

        String[] numbers = numberString.split(separator);

        int sum = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();

        return sum;
    }
}
