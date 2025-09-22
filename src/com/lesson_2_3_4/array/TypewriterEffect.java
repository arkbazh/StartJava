package src.com.lesson_2_3_4.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypewriterEffect {
    public static void main(String[] args) {
        String[] texts = {
                "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n- James Gosling",
                "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n- Robert " +
                        "Martin",
                null,
                ""
        };

        System.out.println();
        for (int i = 0; i < texts.length; i++) {
            try {
                String[] raw = splitToRawTokens(texts[i]);
                String[] cleaned = cleanRawTokens(raw);
                int[] range = findIndexShortestAndLongestWords(cleaned);
                toUpperCaseRange(raw, range);
                printWithEffect(raw, 20);
            } catch (IllegalArgumentException e) {
                System.out.println("Пропускаю текст " + i + ": " + e.getMessage());
            }
        }
    }

    private static String[] splitToRawTokens(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Ошибка: текст не может быть null или пуст");
        }
        // слово = подряд не-пробельные символы, кроме \n; либо одиночный '\n'
        Pattern pattern = Pattern.compile("[^ \\t\\n]+|\\n");
        Matcher matcher = pattern.matcher(text);

        List<String> tokens = new ArrayList<>();
        while (matcher.find()) {
            tokens.add(matcher.group());
        }
        return tokens.toArray(new String[0]);
    }

    private static String[] cleanRawTokens(String[] raw) {
        if (raw == null || raw.length == 0) {
            throw new IllegalArgumentException("Ошибка: массив не может быть null или пуст");
        }
        String[] cleaned = new String[raw.length];
        for (int i = 0; i < raw.length; i++) {
            String token = raw[i];
            if (token == null) {
                throw new IllegalArgumentException("Ошибка: элемент массива [" + i + "] не может быть null");
            }
            cleaned[i] = token.replaceAll("[\\p{P}\\p{S}\\s]+", ""); // слова без пунктуации/пробелов/\n
        }
        return cleaned;
    }

    private static int[] findIndexShortestAndLongestWords(String[] cleaned) {
        if (cleaned == null || cleaned.length == 0) {
            throw new IllegalArgumentException("Ошибка: массив не может быть пуст и длина не может быть 0");
        }

        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        int minIndex = -1;
        int maxIndex = -1;

        for (int i = 0; i < cleaned.length; i++) {
            String word = cleaned[i];
            if (word.isEmpty()) {
                continue;
            }
            int len = word.length();
            if (len < minLength) {
                minLength = len;
                minIndex = i;
            }
            if (len > maxLength) {
                maxLength = len;
                maxIndex = i;
            }
        }

        if (minIndex == -1) {
            throw new IllegalArgumentException("Ошибка: не найдено ни одного слова");
        }
        return new int[]{minIndex, maxIndex};
    }

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
        int start = Math.min(range[0], range[1]);
        int end = Math.max(range[0], range[1]);
        for (int i = start; i <= end; i++) {
            if (!"\n".equals(rawTokens[i])) {
                rawTokens[i] = rawTokens[i].toUpperCase(Locale.ROOT);
            }
        }
    }

    private static void printWithEffect(String[] rawTokens, int delay) {
        if (rawTokens == null) {
            throw new IllegalArgumentException("Ошибка: массив строк не может быть null");
        }
        if (delay < 0) {
            throw new IllegalArgumentException("Ошибка: задержка не может быть меньше 0");
        }
        for (int i = 0; i < rawTokens.length; i++) {
            String word = rawTokens[i];
            if (word == null) {
                throw new IllegalArgumentException("Ошибка: токен [" + i + "] не может быть null");
            }
            if (word.isBlank() && !"\n".equals(word)) {
                throw new IllegalArgumentException("Ошибка: токен [" + i + "] не может быть пустым");
            }
        }

        for (String token : rawTokens) {
            if ("\n".equals(token)) {
                System.out.println();
                continue;
            }
            for (char c : token.toCharArray()) {
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
        System.out.println();
    }
}