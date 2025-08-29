package src.com.lesson_2_3_4.array;

public class FactorialCalculator {
    public static void main(String[] args) {
        int[] numbers;

        numbers = new int[]{};
        print(numbers, calc(numbers));

        numbers = null;
        print(numbers, calc(numbers));

        numbers = new int[]{8, 0, 9};
        print(numbers, calc(numbers));

        numbers = new int[]{-3, 1, 7, 13};
        print(numbers, calc(numbers));

        numbers = new int[]{-22, -0};
        print(numbers, calc(numbers));
    }

    public static int[] calc(int... numbers) {
        if (numbers == null) {
            System.out.println("Ошибка: массив null");
            return null;
        }
        if (numbers.length == 0) {
            System.out.println("Ошибка: длина массива 0");
            return numbers;
        }

        int[] factorials = numbers.clone();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                System.out.printf("Ошибка: факториал %d! не определен\n", factorials[i]);
                continue;
            }
            int fact = factorial(numbers[i]);
            factorials[i] = fact;
        }
        return factorials;
    }

    public static void print(int[] numbers, int[] factorials) {
        if (numbers == null) {
            System.out.println("Ошибка: исходный массив null");
            return;
        }
        if (factorials == null) {
            System.out.println("Ошибка: массив факториалов null");
            return;
        }

        for (int i = 0; i < factorials.length; i++) {
            if (numbers[i] >= 0) {
                System.out.println(expr(numbers[i], factorials[i]));
            }
        }
        System.out.println();
    }

    private static int factorial(int n) {
        return (n == 0 || n == 1) ? 1 : n * factorial(n - 1);
    }

    private static String expr(int num, int fact) {
        if (num == 0 || num == 1) {
            return num + "! = 1 = " + fact;
        }

        StringBuilder sb = new StringBuilder().append(num).append("! = 1");
        for (int i = 2; i <= num; i++) {
            sb.append(" * ").append(i);
        }
        sb.append(" = ").append(fact);
        return sb.toString();
    }
}