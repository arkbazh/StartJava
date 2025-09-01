package src.com.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ElementsRemover {
    public static void main(String[] args) {
        run(-1);
        run(15);
        run(0);
        run(14);
    }

    private static void run(int index) {
        final float[] original = generateRandomFloatArray();
        if (index < 0 || index >= original.length) {
            System.out.printf("Ошибка: индекс %d вне допустимого диапазона(%d - %d)%n%n",
                    index, 0,
                    original.length - 1);
            return;
        }
        final float threshold = original[index];
        System.out.printf("Значение элемента по индексу %d = %.3f%n", index, threshold);
        final float[] modified = removeAboveThresholdAtIndex(original, index);
        printArray(original, modified);
    }

    private static float[] generateRandomFloatArray() {
        float[] array = new float[15];
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextFloat(0, 1);
        }
        return array;
    }

    private static float[] removeAboveThresholdAtIndex(float[] original, int index) {
        float[] modified = Arrays.copyOf(original, original.length);
        float threshold = original[index];
        for (int i = 0; i < modified.length; i++) {
            if (modified[i] > threshold) {
                modified[i] = 0.0f;
            }
        }
        return modified;
    }

    private static void printArray(float[] original, float[] modified) {
        System.out.println("Исходный массив");
        printSingleArray(original);

        System.out.println("Измененный массив");
        printSingleArray(modified);
        System.out.printf("%n");
    }

    private static void printSingleArray(float[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.3f ", array[i]);
            if (i == 7) {
                System.out.println();
            }
        }
        System.out.printf("%n");
    }
}

