package src.com.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Начинаем игру.");
        System.out.println("Введите имя первого игрока...");
        Player firstPlayer = new Player(scanner.nextLine());

        System.out.println("Введите имя второго игрока...");
        Player secondPlayer = new Player(scanner.nextLine());

        GuessNumber guessNumber = new GuessNumber(firstPlayer, secondPlayer);
        guessNumber.play(scanner);
    }
}
