package src.com.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Класс для работы с массивом чисел.
 */
public class ArrayUniqueNumsFiller {
    public static void main(String[] args) {
        print(generateUniqueNumsArray(-30, -10, 23), 23);
        print(generateUniqueNumsArray(10, 50, 10), 10);
        print(generateUniqueNumsArray(-34, -34, -1), -1);
        print(generateUniqueNumsArray(-1, -2, -3), -2);
        print(generateUniqueNumsArray(-5, -8, -2), -2);
    }

    /**
     * Метод генерирует массив уникальных случайных чисел в диапазоне [start; end] длиной 75% от диапазона и
     * печатает его построчно.
     *
     * @param start начало диапазона (включительно)
     * @param end   конец диапазона (включительно)
     * @param count сколько чисел печатать в строке (>=1)
     */
    private static int[] generateUniqueNumsArray(int start, int end, int count) {
        if (start > end) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n%n",
                    start,
                    end);
            return null;
        }
        if (count < 1) {
            System.out.printf("Ошибка: количество чисел в строке не должно быть < 1 (%d)%n%n",
                    count);
            return null;
        }

        int range = end - start + 1;
        int length = (int) (0.75 * range);
        if (length <= 0) {
            System.out.printf("Ошибка: длина массива должна быть > 0 (range=%d, length=%d)%n%n",
                    range,
                    length);
            return null;
        }

        int[] nums = new int[length];
        for (int i = 0; i < nums.length; i++) {
            int num = ThreadLocalRandom.current().nextInt(start, end + 1);
            boolean isUnique = false;
            for (int j = 0; j < i; j++) {
                if (num == nums[j]) {
                    isUnique = true;
                    break;
                }
            }
            if (isUnique) {
                i--;
            } else {
                nums[i] = num;
            }
        }
        return nums;
    }

    private static void print(int[] nums, int count) {
        if (nums == null) {
            return;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
            if ((i + 1) % count == 0) {
                System.out.println();
            }
        }
        System.out.printf("%n");
    }
}

