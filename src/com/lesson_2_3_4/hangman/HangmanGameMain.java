package src.com.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            HangmanGame game = new HangmanGame(scanner);

            boolean playAgain;
            do {
                System.out.println("Игра начинается.");
                game.resetStatsForNewRound();
                game.printState();

                while (!game.isWin() && !game.isLose()) {
                    char guess = game.inputLetter();
                    game.addUsedLetter(guess);
                    boolean hit = game.revealLetterInMask(guess);
                    if (hit) {
                        game.onHit();
                    } else {
                        game.onMiss(guess);
                    }
                    game.printState();
                }

                game.printResult();

                String answer;
                do {
                    System.out.print("Играть заново? Введите yes/no: ");
                    answer = scanner.nextLine().trim();
                } while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));

                playAgain = answer.equalsIgnoreCase("yes");
            } while (playAgain);
        }
    }
}