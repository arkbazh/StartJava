package src.com.lesson_2_3_4.hangman;

import java.util.Locale;
import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean awaitAnswer = false;
            while (true) {
                if (!awaitAnswer) {
                    new HangmanGame().play(scanner);
                    awaitAnswer = true;
                    continue;
                }

                System.out.println("Играть заново? Введите только yes/no");
                String answer = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
                if (answer.equals("yes")) {
                    awaitAnswer = false;
                    continue;
                }
                if (answer.equals("no")) {
                    break;
                }
                System.out.println("Введите только yes / no");
            }
        }
    }
}