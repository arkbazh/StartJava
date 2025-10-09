package src.com.lesson_2_3_4.calculator;

import java.util.Scanner;

class Calculator {

    String[] splitInput() {
        String[] arguments;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите выражение из трех аргументов, например, 2 ^ 10: ");
            String str = scanner.nextLine().trim();
            if (str.isBlank()) {
                System.out.println("Выражение не может быть пустым");
            }
            arguments = str.trim()
                    .replaceAll(",", ".")
                    .replaceAll("\\s+", " ")
                    .split(" ");
        }
        return arguments;
    }

    boolean validateInput(String[] arg) {
        if (arg == null || arg.length != 3) {
            throw new IllegalArgumentException("Ожидаю формат: <число> <оператор> <число>, например: 2 * 8");
        }
        String a = arg[0].trim();
        String operand = arg[1].trim();
        String b = arg[2].trim();

        if (!a.matches("^[+-]?\\d+$")) {
            throw new IllegalArgumentException("Левый операнд должен быть целым числом");
        }
        if (!b.matches("^[+-]?\\d+$")) {
            throw new IllegalArgumentException("Правый операнд должен быть целым числом");
        }
        if (!operand.matches("^[+\\-*/%^]$")) {
            throw new IllegalArgumentException("Оператор должен быть одним из: + - * / % ^");
        }
        if (("/".equals(operand) || "%".equals(operand)) && "0".equals(b)) {
            throw new IllegalArgumentException("Деление на ноль запрещено");
        }
        if ("^".equals(operand)) {
            int expInt = Integer.parseInt(b);
            if (expInt < 0 || expInt > 10) {
                throw new IllegalArgumentException("Показатель степени должен быть от 0 до 10");
            }
        }
        return true;
    }
}
