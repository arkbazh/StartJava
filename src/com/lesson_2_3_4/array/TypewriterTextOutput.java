package src.com.lesson_2_3_4.array;

import java.util.Locale;

/**
 * Класс содержит методы для обработки строк, разделения текста на слова, поиска диапазона слов между самым
 * коротким и самым длинным словом, а также вывода этого диапазона слов в верхнем регистре.
 */
public class TypewriterTextOutput {
    public static void main(String[] args) {
        String str1 = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James " +
                "Gosling";
        String str2 = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin";
        String str3 = null;
        String str4 = "";

        try {
            String[] tokens = splitToWords(str1);
            printArray(tokens, 50);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка обработки str1: " + e.getMessage());
        }

        try {
            String[] tokens = splitToWords(str2);
            printArray(tokens, 50);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка обработки str2: " + e.getMessage());
        }

        try {
            String[] tokens = splitToWords(str3);
            printArray(tokens, 50);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка обработки str3(null): " + e.getMessage());
        }
        try {
            String[] tokens = splitToWords(str4);
            printArray(tokens, 50);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка для str4(пуст): " + e.getMessage());
        }
    }

    /**
     * Метод разделяет входную строку на массив токенов (слова + пунктуация), используя пробелы в качестве
     * разделителей. Токены в диапазоне между самым коротким и самым длинным словом (включая их) приводятся к
     * верхнему регистру.
     *
     * @param str входная строка, которая будет обработана и разделена на токены
     *
     * @return массив токенов из исходной строки с применёнными преобразованиями
     *
     * @throws IllegalArgumentException если входная строка равна {@code null}, пустая, состоит только из
     *                                  пробелов или после очистки не найдено слов
     */
    public static String[] splitToWords(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("Ошибка: строка не может быть null или пуста");
        }

        // Получаем грязный массив без пробелов
        String[] raw = str.split("\\s+");

        // Копируем массив для очистки от знаков препинания
        String[] clean = raw.clone();

        // Очищаем копию массива от знаков препинания
        for (int i = 0; i < clean.length; i++) {
            clean[i] = clean[i].replaceAll("^[^\\p{L}\\p{Nd}]+|[^\\p{L}\\p{Nd}]+$", "");
        }

        // Находим индексы самого длинного и короткого слова (игнорируем пустые после очистки)
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        int minIndex = -1;
        int maxIndex = -1;
        for (int i = 0; i < clean.length; i++) {
            int length = clean[i].length();

            if (length == 0) {
                continue;
            }
            if (length < minLength) {
                minLength = length;
                minIndex = i;
            }
            if (length > maxLength) {
                maxLength = length;
                maxIndex = i;
            }
        }
        if (minIndex == -1 || maxIndex == -1) {
            throw new IllegalArgumentException("Ошибка: не найдено слов после очистки");
        }

        // Убеждаемся, что минимальный индекс расположен до максимального
        if (minIndex > maxIndex) {
            int temp = minIndex;
            minIndex = maxIndex;
            maxIndex = temp;
        }

        // Приводим диапазон слов в верхний регистр
        for (int i = 0; i < raw.length; i++) {
            if (i >= minIndex && i <= maxIndex) {
                raw[i] = raw[i].toUpperCase(Locale.ROOT);
            }
        }
        return raw;
    }

    /**
     * Выводит массив строк по одному символу с задержкой между символами. Если встречается ошибка, выполнение
     * метода прекращается.
     *
     * @param raw   массив строк, который необходимо вывести. Не может быть {@code null}, содержать пустые или
     *              пробельные строки.
     * @param delay задержка в миллисекундах между выводом символов. Должна быть больше 0.
     *
     * @throws IllegalArgumentException если массив raw равен null, содержит null, пустые или пробельные
     *                                  строки, либо значение delay меньше или равно 0.
     */
    public static void printArray(String[] raw, int delay) {
        if (raw == null) {
            throw new IllegalArgumentException("Ошибка: массив строк не может быть null");
        }
        if (delay <= 0) {
            throw new IllegalArgumentException("Ошибка: задержка не может быть меньше 1");
        }
        for (String word : raw) {
            if (word == null || word.isBlank()) {
                throw new IllegalArgumentException("Ошибка: слово не может быть пустым");
            }
            for (int i = 0; i < word.length(); i++) {
                try {
                    System.out.print(word.charAt(i));
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println();
                    return;
                }
            }
            System.out.print(" ");
        }
        System.out.printf("%n");
    }
}