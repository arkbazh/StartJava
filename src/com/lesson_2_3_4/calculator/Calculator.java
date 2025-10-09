package src.com.lesson_2_3_4.calculator;

import java.util.Scanner;

class Calculator {

    public String[] getExpression() {
        String[] exp;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите выражение из трех аргументов, например, 2 ^ 10: ");
            String str = scanner.nextLine().trim();
            if (str.isBlank()) {
                System.out.println("Выражение не может быть пустым");
            }
            exp = str.trim()
                    .replaceAll(",", ".")
                    .replaceAll("\\s+", " ")
                    .split(" ");
            if (exp.length != 3) {
                System.out.println("Error");
            }
            if (!exp[0].matches("^\\d+$")) {
                System.out.println("Error");
            }
            if (!exp[2].matches("^\\d+$")) {
                System.out.println("Error");
            }
            if (!exp[1].matches("[+\\-*/%^]")) {
                System.out.println("Error");
            }
            //  если оператор / или % правый операнд не равен 0
            if (exp[1].matches("[/%]") && exp[2].matches("0")) {
                System.out.println("Error");
            }
        }
        return exp;
    }

}
