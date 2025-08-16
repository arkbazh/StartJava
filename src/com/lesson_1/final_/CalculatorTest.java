package src.com.lesson_1.final_;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Calculator calc = new Calculator();
        String option = "yes";

        while (!"no".equals(option)) {
            System.out.print("Введите первое число: ");
            calc.setA(console.nextInt());

            System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
            calc.setSign(console.next().charAt(0));

            System.out.print("Введите второе число: ");
            calc.setB(console.nextInt());

            calc.calculate();
            console.nextLine();

            do {
                System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
                option = console.nextLine();
            } while (!"yes".equals(option) && !"no".equals(option));
        }
        console.close();
    }
}
