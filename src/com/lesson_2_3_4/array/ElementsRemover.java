package src.com.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ElementsRemover {
    public static void main(String[] args) {
        double[] original = generateRandomDoubleArray();
        double[] truncate = truncateAboveThresholdAtIndex(original, -1);
        printArray(original, truncate);

        original = generateRandomDoubleArray();
        truncate = truncateAboveThresholdAtIndex(original, 15);
        printArray(original, truncate);

        original = generateRandomDoubleArray();
        truncate = truncateAboveThresholdAtIndex(original, 0);
        printArray(original, truncate);

        original = generateRandomDoubleArray();
        truncate = truncateAboveThresholdAtIndex(original, 14);
        printArray(original, truncate);
    }

    private static double[] generateRandomDoubleArray() {
        double[] array = new double[15];
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextDouble(0, 1);
        }
        return array;
    }

    private static double[] truncateAboveThresholdAtIndex(double[] array, int index) {
        if (array == null || array.length == 0) {
            return null;
        }
        if (index < 0 || index >= array.length) {
            System.out.printf("Ошибка: индекс %d вне допустимого диапазона(%d - %d). Массив не " +
                            "изменился\n",
                    index, 0,
                    array.length - 1);
            return array;
        }
        double[] copy = Arrays.copyOf(array, array.length);
        double threshold = array[index];
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] > threshold) {
                copy[i] = 0.0;
            }
        }
        return copy;
    }

    private static void printArray(double[] original, double[] truncated) {
        System.out.println("Исходный массив");
        for (int i = 0; i < original.length; i++) {
            System.out.printf("%.3f ", original[i]);
            if (i == 7) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Измененный массив");
        for (int i = 0; i < truncated.length; i++) {
            System.out.printf("%.3f ", truncated[i]);
            if (i == 7) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
    }
}

