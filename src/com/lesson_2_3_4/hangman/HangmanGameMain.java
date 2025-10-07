package src.com.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                new HangmanGame().playOnce(scanner);
            } while (askReplay(scanner));
        }
    }

    private static boolean askReplay(Scanner scanner) {
        String answer;
        do {
            System.out.print("Играем заново? Введите yes/no: ");
            answer = scanner.nextLine().trim();
        } while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));
        return answer.equalsIgnoreCase("yes");
    }
}