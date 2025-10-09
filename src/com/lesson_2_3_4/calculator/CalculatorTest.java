package src.com.lesson_2_3_4.calculator;

import java.util.Locale;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator test = new Calculator();
        String[] expression = test.splitInput();
        test.validateInput(expression);
        double result = calc(expression);
        System.out.printf("Результат вычисления: %s%n",
                String.format(Locale.ROOT, "%.3f", result)
                        .replaceAll("\\.?0+$", ""));

    }

    private static double calc(String[] exp) {
        int a = Integer.parseInt(exp[0]);
        int b = Integer.parseInt(exp[2]);
        String operator = exp[1];
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> (double) a / b;
            case "%" -> Math.floorMod(a, b);
            case "^" -> Math.pow(a, b);
            default -> throw new IllegalStateException("Неизвестный оператор: " + operator);
        };
    }
}
