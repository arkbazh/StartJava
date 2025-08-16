package src.com.lesson_2_3_4.array;

import java.util.Arrays;

public class TransactionReverser {
    public static void main(String[] args) {
        int[] original = new int[0];
        int[] reversed = reverse(original);
        printTransactions(original, reversed);

        original = null;
        reversed = reverse(original);
        printTransactions(original, reversed);

        original = new int[]{5};
        reversed = reverse(original);
        printTransactions(original, reversed);

        original = new int[]{6, 8, 9, 1};
        reversed = reverse(original);
        printTransactions(original, reversed);

        original = new int[]{13, 8, 5, 3, 2, 1, 1};
        reversed = reverse(original);
        printTransactions(original, reversed);
    }

    public static int[] reverse(int[] original) {
        if (original == null) {
            return null;
        }
        if (original.length == 0) {
            return new int[0];
        }
        int[] reversed = new int[original.length];
        int index = original.length;

        for (int value : original) {
            reversed[--index] = value;
        }
        return reversed;
    }

    private static void printTransactions(int[] original, int[] reversed) {
        if (original == null) {
            System.out.println("Исходные транзакции: Null(Ошибка данных)");
        } else if (original.length == 0) {
            System.out.println("Исходные транзакции: Пустой массив(Нет данных)");
        } else {
            System.out.print("Исходные транзакции: ");
            System.out.println(Arrays.toString(original));
            System.out.print(" В обратном порядке: ");
            System.out.println(Arrays.toString(reversed));
        }
    }
}
