package src.com.lesson_2_3_4.calculator;

import java.util.Locale;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String[] expression = calculator.splitInput();
        double result = Double.NaN;
        try {
            calculator.validateInput(expression);
            result = calculator.calculate(expression);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        if (!Double.isNaN(result)) {
            System.out.printf("Результат вычисления: %s%n",
                    String.format(Locale.ROOT, "%.3f", result)
                            .replaceAll("\\.?0+$", ""));
        }
    }
}
