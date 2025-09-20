package src.com.lesson_2_3_4.array;

import java.util.Locale;

public class TypewriterEffect {
    public static void main(String[] args) {
        String[] quotes = {
                "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                        "- James " +
                        "Gosling",

                "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                        "- Robert Martin",

                null,

                ""
        };
        for (String quote : quotes) {
            if (quote == null) {
                System.out.println("Ошибка: цитата равна null");
                continue;
            }
            if (quote.isBlank()) {
                System.out.println("Ошибка: цитата пуста");
                continue;
            }
            String[] tokens = splitRawTokens(quote);
            int[] range = findIndexShortestAndLongestWords(quote);
            toUpperCaseRange(tokens, range);
            printWithEffect(tokens, 100);
        }
    }

    /**
     * Определяет индексы самого короткого и самого длинного слова в переданной строке.
     *
     * <p>
     * Метод находит слова, удаляя все знаки препинания и деля строку на токены. Возвращает индексы самого
     * короткого и самого длинного слова, гарантируя, что индекс самого короткого слова всегда будет меньше
     * или равен индексу самого длинного слова. Если строка пустая или не содержит слов, выбрасывает
     * исключение IllegalArgumentException.
     *
     * @param text строка, в которой необходимо определить индексы самого короткого и самого длинного слова.
     *             Не может быть null или пустой.
     *
     * @return массив из двух целых чисел, индексы самого короткого и самого длинного слова.
     *
     * @throws IllegalArgumentException если строка пустая, null или не содержит слов после очистки.
     */
    private static int[] findIndexShortestAndLongestWords(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Ошибка: строка не может быть null или пуста");
        }
        // Сплитим по пробельным символам
        String[] tokens = text.split("[ \\t]+");

        // Находим индексы самого длинного и короткого слова
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        int minIndex = -1;
        int maxIndex = -1;
        for (int i = 0; i < tokens.length; i++) {
            // Удаляем пунктуацию и символы из токена, чтобы корректно считать длину слова
            String cleaned = tokens[i].replaceAll("[\\p{P}\\p{S}\\s]+", "");
            int length = cleaned.length();
            // Игнорируем пробелы
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
        // Если не найдено ни одного слова, ни один индекс не обновляется
        if (minIndex == -1) {
            throw new IllegalArgumentException("Ошибка: не найдено слов после очистки");
        }
        // Сортируем индексы по возрастанию
        int start = Math.min(minIndex, maxIndex);
        int end = Math.max(minIndex, maxIndex);

        return new int[]{start, end};
    }

    /**
     * Разделяет строку на массив токенов, используя пробелы как разделитель. Метод сохраняет знаки препинания
     * в токенах.
     *
     * @param text строка, которая будет разбита на токены. Не может быть null или пустой.
     *
     * @return массив строк, представляющих токены, разделенные пробелами.
     *
     * @throws IllegalArgumentException если строка null или пуста.
     */
    private static String[] splitRawTokens(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Ошибка: строка не может быть null или пуста");
        }
        // Возвращаем массив без пробелов, но со знаками препинания
        return text.split("[ \\t]+");
    }

    /**
     * Преобразует значения в массиве строк в верхний регистр в пределах указанного диапазона индексов.
     *
     * @param rawTokens массив строк, который необходимо изменить. Не должен быть null.
     * @param range     массив из двух элементов, определяющий начальный и конечный индекс диапазона. Первое
     *                  значение - начало диапазона (включительно), второе - конец диапазона (включительно).
     *                  Должен содержать ровно 2 элемента, где начало диапазона не больше конца.
     *
     * @throws IllegalArgumentException если массив строк равен null, если массив диапазона не содержит ровно
     *                                  двух элементов, если начало или конец диапазона выходит за границы
     *                                  массива строк, либо если начало диапазона больше его конца.
     */
    private static void toUpperCaseRange(String[] rawTokens, int[] range) {
        if (rawTokens == null) {
            throw new IllegalArgumentException("Ошибка: массив токенов null");
        }
        if (range == null || range.length != 2) {
            throw new IllegalArgumentException("Ошибка: массив диапазона должен содержать 2 элемента");
        }
        if (range[0] < 0 || range[1] >= rawTokens.length) {
            throw new IllegalArgumentException("Ошибка: диапазон вне массива токенов");
        }
        if (range[0] > range[1]) {
            throw new IllegalArgumentException("Ошибка: начало диапазона не может быть больше конца");
        }
        for (int i = range[0]; i <= range[1]; i++) {
            rawTokens[i] = rawTokens[i].toUpperCase(Locale.ROOT);
        }
    }

    /**
     * Выводит символы строк из массива с заданной задержкой между символами. После каждой строки добавляется
     * пробел. Если один из токенов пустой или null, выбрасывается исключение. Если задержка отрицательная,
     * выбрасывается исключение.
     *
     * @param rawTokens массив строк, символы которых нужно вывести. Не может быть null, строки внутри массива
     *                  не могут быть null или пустыми.
     * @param delay     задержка в миллисекундах между выводом символов. Не может быть отрицательной.
     *
     * @throws IllegalArgumentException если массив равен null, если одна из строк в массиве равна null или
     *                                  пуста, либо если задержка отрицательна.
     */
    private static void printWithEffect(String[] rawTokens, int delay) {
        if (rawTokens == null) {
            throw new IllegalArgumentException("Ошибка: массив строк не может быть null");
        }
        if (delay < 0) {
            throw new IllegalArgumentException("Ошибка: задержка не может быть меньше 0");
        }
        for (int i = 0; i < rawTokens.length; i++) {
            if (rawTokens[i] == null || rawTokens[i].isBlank()) {
                throw new IllegalArgumentException("Ошибка: токен [" + i + "] не может быть пустым");
            }
        }
        for (int i = 0; i < rawTokens.length; i++) {
            for (char c : rawTokens[i].toCharArray()) {
                try {
                    System.out.print(c);
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