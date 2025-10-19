package calculator;

public class StringAddCalculator {
    public static int add(String input) {
        if (input == null) {
            return 0;
        }

        if (input.isEmpty()) {
            return 0;
        }

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("공백 입력을 허용하지 않습니다.");
        }

        String numbersPart;

        if (input.indexOf("//") == 0) {
            int newlineIndex = input.indexOf("\n");
            int seperatorLength = 1;

            if (newlineIndex == -1) {
                newlineIndex = input.indexOf("\\n");
                seperatorLength = 2;
            }

            if (newlineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }

            String customDelimiter = input.substring(2, newlineIndex);
            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 비어 있습니다.");
            } else if (customDelimiter.length() != 1) {
                throw new IllegalArgumentException("커스텀 구분자는 1개만 가능합니다.");
            }

            numbersPart = input.substring(newlineIndex + seperatorLength);
            numbersPart = numbersPart.replace(customDelimiter, ",");
        } else {
            numbersPart = input;
        }

        String[] tokens = numbersPart.split("[,:]");
        int sum = 0;

        for (int i = 0; i < tokens.length; i++) {
            int num;
            String token = tokens[i];

            if (token.isEmpty()) {
                throw new IllegalArgumentException("빈 값은 허용되지 않습니다.");
            }

            if (token.contains(" ")) {
                throw new IllegalArgumentException("공백이 포함된 값은 허용되지 않습니다.");
            }

            try {
                num = Integer.parseInt(token);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("정수가 아닌 값이 포함되어 있습니다.");
            }

            if (num < 0) {
                throw new IllegalArgumentException("양수가 아닌 값이 포함되어 있습니다.");
            } else {
                sum += num;
            }
        }

        return sum;
    }
}
