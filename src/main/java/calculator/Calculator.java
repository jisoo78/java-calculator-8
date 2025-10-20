package calculator;

public class Calculator {
    public int add(String numberString) {
        if (numberString == null || numberString.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력했습니다.");
        }

        String separator = ",|;";

        if (numberString.startsWith("//")) {
            int newlineIndex = numberString.indexOf("\n");

            if (newlineIndex == -1) {
                newlineIndex = numberString.indexOf("\\n");
            }

            if (newlineIndex == -1) {
                throw new IllegalArgumentException("잘못된 커스텀 구분자를 입력했습니다. 커스텀 구분자는 //과 \\n 사이에 입력해주세요.");
            }

            if (newlineIndex != -1) {
                separator = numberString.substring(2, newlineIndex);

                if (numberString.charAt(newlineIndex) == '\\') {
                    numberString = numberString.substring(newlineIndex + 2);
                }
            }
        }

        try {
            String[] numbers = numberString.split(separator);
            int sum = 0;

            for (String numberStr : numbers) {
                numberStr = numberStr.trim();
                int num = Integer.parseInt(numberStr);

                if (num < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }

                sum += num;
            }
            return sum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("허용되지 않는 값입니다.");
        }
    }
}
