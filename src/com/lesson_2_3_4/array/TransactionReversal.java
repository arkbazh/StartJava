package src.com.lesson_2_3_4.array;

/*
 реализуйте метод, принимающий массив целых чисел разной длины, обозначающих значения транзакций клиентов
 вызовите его для следующих данных (без использования varargs):
 массив нулевой длины
 null
 5
 6, 8, 9, 1
 13, 8, 5, 3, 2, 1, 1

 выполните реверс значений массива без сортировки
 исходный массив не должен меняться
 обработайте особые случаи:
 пустой массив (нет данных)
 null (ошибка в данных)
 выведите значения массива, соблюдая все отступы, как в образце:
 Исходные транзакции: [1, 2, 3, 4]
  В обратном порядке: [4, 3, 2, 1]
*/

import java.util.Arrays;

public class TransactionReversal {
   public static int[] reverse(int[] data) {
      if (data == null) {
         return null;
      }
      if (data.length == 0) {
         return new int[0];
      }
      int length = data.length;
      for (int i = 0, j = i; i < length; i++) {

      }

   }

   public static void main(String[] args) {
   }
}
