package src.com.lesson_2_3_4.hangman;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

class HangmanGame {
    private static final String[] GALLOWS = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };

    private static final String[] DICTIONARY = {"чай", "англия", "агент", "работа", "игра"};
    private static final int ATTEMPTS = GALLOWS.length;
    private static final Pattern CYRILLIC_PATTERN = Pattern.compile("^[а-яёА-ЯЁ]$");

    private final Scanner scanner;
    private final StringBuilder usedLetters = new StringBuilder();
    private final StringBuilder wrongLetters = new StringBuilder();
    private char[] mask;
    private int mistakes;
    private String secretWord;

    HangmanGame(Scanner scanner) {
        this.scanner = scanner;
        this.secretWord = "";
        this.mask = new char[0];
    }

    void resetStatsForNewRound() {
        secretWord = DICTIONARY[ThreadLocalRandom.current().nextInt(DICTIONARY.length)];
        mask = "*".repeat(secretWord.length()).toCharArray();
        mistakes = 0;
        usedLetters.setLength(0);
        wrongLetters.setLength(0);
    }

    char inputLetter() {
        while (true) {
            System.out.print("Введите букву: ");
            String input = scanner.nextLine().trim().toLowerCase(Locale.ROOT);

            if (!CYRILLIC_PATTERN.matcher(input).matches()) {
                System.out.println("Нужно ввести ровно одну букву кириллицы.");
                continue;
            }

            if (usedLetters.indexOf(input) >= 0) {
                System.out.println("Буква уже была.");
                continue;
            }

            return input.charAt(0);
        }
    }

    void addUsedLetter(char guess) {
        usedLetters.append(guess);
    }

    boolean revealLetterInMask(char guess) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guess) {
                mask[i] = Character.toUpperCase(guess);
                return true;
            }
        }
        return false;
    }

    void onHit() {
        if (mistakes > 0) {
            mistakes--;
        }
    }

    void onMiss(char guess) {
        if (wrongLetters.indexOf(String.valueOf(guess)) < 0) {
            wrongLetters.append(guess);
        }
        mistakes++;
    }

    void printState() {
        for (int i = 0; i < Math.min(mistakes, GALLOWS.length); i++) {
            System.out.println(GALLOWS[i]);
        }
        System.out.println(new String(mask));
        System.out.println("Неверные буквы: " + wrongLetters);
        int livesLeft = Math.max(0, ATTEMPTS - mistakes);
        System.out.println("Осталось попыток: " + livesLeft + " из " + ATTEMPTS + ".");
    }

    boolean isWin() {
        return Arrays.toString(mask).equalsIgnoreCase(secretWord);
    }

    boolean isLose() {
        return mistakes >= ATTEMPTS;
    }

    void printResult() {
        if (isWin()) {
            System.out.println("Победа! Слово: " + secretWord);
        } else if (isLose()) {
            System.out.println("Проигрыш. Слово: " + secretWord);
        }
    }
}