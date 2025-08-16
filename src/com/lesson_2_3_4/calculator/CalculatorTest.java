package src.com.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String answer = "yes";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Калькулятор открыт");
        do {
            System.out.println("Введите первое число");
            int firstNum = scanner.nextInt();

            System.out.println("Введите знак операции");
            char operator = scanner.next().charAt(0);

            System.out.println("Введите второе число");
            int secondNum = scanner.nextInt();

            System.out.println("Результат вычисления = " +
                    calculator.calculate(firstNum, operator, secondNum));

            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]");
                answer = scanner.next();
            } while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));
        } while (answer.equalsIgnoreCase("yes"));
        System.out.println("Калькулятор закрыт");
        scanner.close();
    }
}
