package src.com.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Утилитарный класс для работы с массивом чисел.
 */
public class ArrayUniqueNumbersFiller {
    public static void main(String[] args) {
        generateAndPrintUniqueNumberArray(-30, -10, 23);
        generateAndPrintUniqueNumberArray(10, 50, 10);
        generateAndPrintUniqueNumberArray(-34, -34, -1);
        generateAndPrintUniqueNumberArray(-1, -2, -3);
        generateAndPrintUniqueNumberArray(-5, -8, -2);
    }

    /**
     * Генерирует массив уникальных случайных чисел в диапазоне [start; end] длиной 75% от диапазона и
     * печатает его построчно.
     *
     * @param start начало диапазона (включительно)
     * @param end   конец диапазона (включительно)
     * @param count сколько чисел печатать в строке (>=1)
     */
    private static void generateAndPrintUniqueNumberArray(int start, int end, int count) {
        if (start > end) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n%n", start, end);
            return;
        }
        if (count < 1) {
            System.out.printf("Ошибка: количество чисел в строке не должно быть < 1 (%d)%n%n", count);
            return;
        }

        int range = end - start + 1;
        int length = (int) (0.75 * range);
        if (length <= 0) {
            System.out.printf("Ошибка: длина массива должна быть > 0 (range=%d, length=%d)%n%n", range,
                    length);
            return;
        }

        int[] nums = new int[length];
        for (int i = 0; i < nums.length; i++) {
            int num = ThreadLocalRandom.current().nextInt(start, end + 1);
            boolean exists = false;
            for (int j = 0; j < i; j++) {
                if (num == nums[j]) {
                    exists = true;
                    break;
                }
            }
            if (exists) {
                i--;
            } else {
                nums[i] = num;
            }
        }

        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        for (int i = 0; i < sortedNums.length; i++) {
            System.out.print(sortedNums[i] + " ");
            if ((i + 1) % count == 0) {
                System.out.println();
            }
        }
        System.out.printf("%n%n");
    }
}

