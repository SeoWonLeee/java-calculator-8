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

        return 0;
    }
}
