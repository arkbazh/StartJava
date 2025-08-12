package src.com.lesson_2_3_4.array;

import java.util.Arrays;

public class Transaction {
   public static int[] reverse(int[] transaction) {
      if (transaction == null) {
         return null;
      }
      if (transaction.length == 0) {
         return new int[0];
      }
      int length = transaction.length;
      int[] reverse = Arrays.copyOf(transaction, length);
      for (int i = 0, j = length - 1; i < length; i++, j--) {
         reverse[i] = transaction[j];
      }
      return reverse;
   }

   private static void printTransactions(int[] transaction) {
      System.out.print("Исходные транзакции: ");
      System.out.println(transaction == null ? "Транзакций нет" : Arrays.toString(transaction));

      System.out.print("В обратном порядке: ");
      System.out.println(transaction == null ? "Транзакций нет" : Arrays.toString(reverse(transaction)));
   }

   public static void main(String[] args) {
      int[] emptyTransactions = new int[0];
      int[] nullTransactions = null;
      int[] defaultTransactions = new int[5];
      int[] sampleTransactions = new int[] { 6, 8, 9, 1 };
      int[] anotherTransactions = new int[] { 13, 8, 5, 3, 2, 1, 1 };

      printTransactions(emptyTransactions);
      printTransactions(nullTransactions);
      printTransactions(defaultTransactions);
      printTransactions(sampleTransactions);
      printTransactions(anotherTransactions);
   }
}
