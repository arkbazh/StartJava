package src.com.lesson_2_3_4.array;

public class CharacterTrianglePrinter {
    public static void main(String[] args) {
        printTriangleFromSequence(generateCharSequence('0', '9', true));
        printTriangleFromSequence(generateCharSequence('/', '?', false));
        printTriangleFromSequence(generateCharSequence('A', 'Z', false));
    }

    /**
     * Генерирует строку символов из интервала [start, end] В заданном направлении.
     *
     * <p>
     * Строка сортируется по возрастанию или убыванию. Если параметры не соответствуют, возвращается пустая
     * строка.
     *
     * @param start     начальный символ
     * @param end       конечный символ
     * @param ascending true - по возрастанию, false - по убыванию
     *
     * @return строка символов; строка пустая.
     */
    private static String generateCharSequence(char start, char end, boolean ascending) {
        if (ascending && start > end) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n", (int) start, (int) end);
            return "";
        }
        if (!ascending && start < end) {
            System.out.printf("Ошибка: правая граница (%d) > левой (%d)%n", (int) end, (int) start);
            return "";
        }

        StringBuilder sb = new StringBuilder();
        if (ascending) {
            for (char c = start; c <= end; c++) {
                sb.append(c);
            }
        } else {
            for (char c = start; c >= end; c--) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Рисует равнобедренный треугольник из строки символов.
     *
     * <p>
     * Если {@code sequence == null || sequence.isEmpty} выводит сообщение об ошибке и завершает работу
     *
     * @param sequence строка символов
     */
    private static void printTriangleFromSequence(String sequence) {
        if (sequence == null) {
            System.out.printf("Ошибка: аргумент null%n%n");
            return;
        }
        if (sequence.isBlank()) {
            System.out.printf("Ошибка: аргумент нулевой длины%n%n");
            return;
        }

        int height = sequence.length();
        for (int i = 0; i < height; i++) {
            char c = sequence.charAt(i);
            int indent = height - 1 - i;
            int width = i * 2 + 1;
            System.out.println(" ".repeat(indent) + String.valueOf(c).repeat(width));
        }
        System.out.println();
    }
}