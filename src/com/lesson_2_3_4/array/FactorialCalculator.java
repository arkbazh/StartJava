package src.com.lesson_2_3_4.array;

public class FactorialCalculator {
    public static void main(String[] args) {
        int[] numbers = {};
        printFactorials(numbers, calc(numbers));

        numbers = null;
        printFactorials(numbers, calc(numbers));

        numbers = new int[]{8, 0, 9};
        printFactorials(numbers, calc(numbers));

        numbers = new int[]{-3, 1, 7, 13};
        printFactorials(numbers, calc(numbers));

        numbers = new int[]{-22, -0};
        printFactorials(numbers, calc(numbers));
    }

    private static int[] calc(int... numbers) {
        if (numbers == null) {
            System.out.println("Ошибка: массив null");
            return null;
        }
        if (numbers.length == 0) {
            System.out.println("Ошибка: длина массива 0");
            return numbers;
        }

        int[] factorials = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                System.out.printf("Ошибка: факториал %d! не определен\n", numbers[i]);
                continue;
            }
            factorials[i] = factorial(numbers[i]);
        }
        return factorials;
    }

    private static int factorial(int num) {
        return (num == 0 || num == 1) ? 1 : num * factorial(num - 1);
    }

    private static void printFactorials(int[] numbers, int[] factorials) {
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
                System.out.println(formFactorialExpr(numbers[i], factorials[i]));
            }
        }
        System.out.println();
    }

    private static String formFactorialExpr(int num, int fact) {
        if (num == 0 || num == 1) {
            return num + "! = " + fact;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(num).append("! = 1");
        for (int i = 2; i <= num; i++) {
            sb.append(" * ").append(i);
        }
        sb.append(" = ").append(fact);
        return sb.toString();
    }
}