package src.com.lesson_2_3_4.array;

import java.util.Arrays;

public class FactorialCalculator {
    public static void main(String[] args) {
        print();
        print(null);
        print(8, 0, 9);
        print(-3, 1, 7, 13);
        print(-22, -0);
    }

    // Только выводим
    public static void print(int... numbers) {
        if (numbers == null) {
            System.out.println("Ошибка: массив null\n");
            return;
        }
        if (numbers.length == 0) {
            System.out.println("Ошибка: длина массива 0\n");
            return;
        }

        System.out.println("Исходный массив: " + Arrays.toString(numbers));

        int[] factorials = calc(numbers);

        for (int i = 0; i < factorials.length; i++) {
            int n = numbers[i];
            if (n < 0) {
                System.out.printf("Ошибка: факториал %d! не определен\n", n);
                continue;
            }
            if (n <= 1) {
                System.out.println(n + "! = 1");
                continue;
            }
            StringBuilder expr = new StringBuilder();
            expr.append(n).append("! = 1");
            for (int j = 2; j <= n; j++) {
                expr.append(" * ").append(j);
            }
            int f = factorials[i];
            expr.append(" = ").append(f);
            System.out.println(expr);
        }
        System.out.println();
    }

    // Только считаем
    private static int[] calc(int[] numbers) {
        if (numbers == null) {
            return null;
        }
        int[] factorials = numbers.clone();
        for (int i = 0; i < factorials.length; i++) {
            if (factorials[i] < 0) {
                continue;
            }
            factorials[i] = factorial(factorials[i]);
        }
        return factorials;
    }

    // Только считаем
    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}