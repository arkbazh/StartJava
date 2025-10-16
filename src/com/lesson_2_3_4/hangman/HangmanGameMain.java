package src.com.lesson_2_3_4.hangman;

import java.util.Locale;
import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Играть? Введите yes/no: ");
            String answer = scanner.nextLine().trim().toLowerCase(Locale.ROOT);

            while (true) {
                if ("yes".equals(answer)) {
                    new HangmanGame().play(scanner);
                    System.out.print("Играть? Введите yes/no: ");
                    answer = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
                    continue;
                }
                if ("no".equals(answer)) {
                    break;
                }
                System.out.println("Введите только yes/no");
                System.out.print("Играть? Введите yes/no: ");
                answer = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
            }
        }
    }
}