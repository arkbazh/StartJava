package src.com.lesson_2_3_4.hangman;

import java.util.Locale;
import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                new HangmanGame().play(scanner);
            } while (askReplay(scanner));
        }
    }

    private static boolean askReplay(Scanner scanner) {
        String answer;
        do {
            System.out.print("Играем заново? Введите yes/no: ");
            answer = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
        } while (!answer.equals("yes") && !answer.equals("no"));
        return answer.equals("yes");
    }
}