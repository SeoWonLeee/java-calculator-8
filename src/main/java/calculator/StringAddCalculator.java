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

        if (input.indexOf("//") == 0) {
            int newlineIndex = input.indexOf("\n");
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }
            String customDelimiter = input.substring(2, newlineIndex);
            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 비어 있습니다.");
            } else if (customDelimiter.length() != 1) {
                throw new IllegalArgumentException("커스텀 구분자는 1개만 가능합니다.");
            }
        }

        return 0;
    }
}
