package src.com.lesson_2_3_4.array;

import java.util.Arrays;

public class TransactionReverser {
    public static int[] reverse(int[] original) {
        if (original == null) {
            return null;
        }
        if (original.length == 0) {
            return new int[0];
        }
        int length = original.length;
        int[] reversed = new int[length];
        int index = length - 1;

        for (int value : original) {
            reversed[index--] = value;
        }
        return reversed;
    }

    private static void printTransactions(int[] transaction) {
        System.out.print("Исходные транзакции: ");
        System.out.println(transaction == null ? "Транзакций нет" : Arrays.toString(transaction));

        System.out.print(" В обратном порядке: ");
        System.out.println(transaction == null ? "Транзакций нет" : Arrays.toString(reverse(transaction)));
    }

    public static void main(String[] args) {
        int[] original = new int[0];
        reverse(original);
        printTransactions(original);

        original = null;
        reverse(original);
        printTransactions(original);

        original = new int[] { 5 };
        reverse(original);
        printTransactions(original);
        //
        original = new int[] { 6, 8, 9, 1 };
        reverse(original);
        printTransactions(original);

        original = new int[] { 13, 8, 5, 3, 2, 1, 1 };
        reverse(original);
        printTransactions(original);
    }
}
