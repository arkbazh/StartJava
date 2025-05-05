package src.com.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {
    private Player firstPlayer;
    private Player secondPlayer;

    public GuessNumber(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void play(Scanner scanner) {
        do {
            int hiddenNum = (int) (Math.random() * 100) + 1;
            firstPlayer.setNum(0);
            secondPlayer.setNum(0);

            while (firstPlayer.getNum() != hiddenNum &&
                    secondPlayer.getNum() != hiddenNum) {
                System.out.println(firstPlayer + " введите число");
                firstPlayer.setNum(scanner.nextInt());
                scanner.nextLine();

                System.out.println(secondPlayer + " введите число");
                secondPlayer.setNum(scanner.nextInt());
                scanner.nextLine();

                if (firstPlayer.getNum() == hiddenNum) {
                    System.out.println("Выиграл: " + firstPlayer);
                    break;
                }
                if (secondPlayer.getNum() == hiddenNum) {
                    System.out.println("Выиграл: " + secondPlayer);
                    break;
                }
            }
            System.out.println("Хотите продолжить игру? [yes/no]:");
        } while (scanner.nextLine().trim().toLowerCase().equals("yes"));
    }
}
