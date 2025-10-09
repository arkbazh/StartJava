package src.com.lesson_2_3_4.hangman;

import java.util.Locale;
import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean playNextRound;
            do {
                new HangmanGame().play(scanner);
                System.out.println("Играть заново? Введите только yes/no");
                String answer = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
                playNextRound = answer.equals("yes");
            } while (playNextRound);
        }
    }
}