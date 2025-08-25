package src.com.lesson_2_3_4.array;

import java.util.Arrays;

public class FactorialCalculator {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(factorials()));
        System.out.println(Arrays.toString(factorials(null)));
        System.out.println(Arrays.toString(factorials(8, 0, 9)));
        System.out.println(Arrays.toString(factorials(-3, 1, 7, 13)));
        System.out.println(Arrays.toString(factorials(-22, -0)));
    }

    public static int[] factorials(int... input) {
        System.out.println("Исходный массив: " + Arrays.toString(input));
        if (input == null) {
            System.out.println("Ошибка: null");
            return null;
        }
        if (input.length == 0) {
            System.out.println("Ошибка: массив нулевой длины");
            return input;
        }

        int[] output = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            int n = input[i];
            // n < 0
            if (n < 0) {
                System.out.println("Ошибка: факториал " + input[i] + "! не определен");
                output[i] = input[i];
                continue;
            }
            // n == 0 || n == 1
            if (n <= 1) {
                output[i] = n;
                continue;
            }
            // n > 1
            int fact = 1;
            StringBuilder expr = new StringBuilder();
            for (int j = 2; j <= n; j++) {
                fact *= j;
                expr.append(" * ").append(j);
            }
            output[i] = fact;

            // собираем строку через тернарник, но он всегда идет по второй ветке
            String line = (n <= 1)
                    ? n + "! = 1"
                    : n + expr.toString() + "=" + fact;
        }
        return output;
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) n = 1;
        else n *= factorial(n - 1);
        return n;
    }
}