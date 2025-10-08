package src.com.lesson_2_3_4.hangman;

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

    private final StringBuilder usedLetters;
    private final StringBuilder wrongLetters;
    private String secretWord;
    private char[] mask;
    private int mistakes;

    HangmanGame() {
        this.usedLetters = new StringBuilder();
        this.wrongLetters = new StringBuilder();
        this.secretWord = DICTIONARY[ThreadLocalRandom.current().nextInt(DICTIONARY.length)];
        this.mask = "*".repeat(secretWord.length()).toCharArray();
        this.mistakes = 0;
    }

    void play(Scanner scanner) {
        while (!isWin() && !isLose()) {
            printState();
            char letter = inputLetter(scanner);
            addUsedLetter(letter);
            if (revealLetterInMask(letter)) {
                onHit();
            } else {
                onMiss(letter);
            }
        }
        printState();
        printFinalMessage();
    }

    private char inputLetter(Scanner scanner) {
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

    private void addUsedLetter(char guess) {
        usedLetters.append(guess);
    }

    private boolean revealLetterInMask(char guess) {
        boolean hit = false;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guess) {
                mask[i] = Character.toUpperCase(guess);
                hit = true;
            }
        }
        return hit;
    }

    private void onHit() {
        if (mistakes > 0) {
            mistakes--;
        }
    }

    private void onMiss(char guess) {
        if (wrongLetters.indexOf(String.valueOf(guess)) < 0) {
            wrongLetters.append(guess);
        }
        mistakes++;
    }

    private void printState() {
        int miss = Math.min(wrongLetters.length(), GALLOWS.length);
        for (int i = 0; i < miss; i++)
            System.out.println(GALLOWS[i]);
        System.out.println(new String(mask));
        System.out.println("Неверные буквы: " + wrongLetters);
        int livesLeft = Math.max(0, ATTEMPTS - miss);
        System.out.println("Осталось попыток: " + livesLeft + " из " + ATTEMPTS + ".");
    }

    private boolean isWin() {
        return !new String(mask).contains("*");
    }

    private boolean isLose() {
        return mistakes >= ATTEMPTS;
    }

    private void printFinalMessage() {
        if (isWin()) {
            System.out.println("Победа! Слово: " + secretWord);
        } else {
            System.out.println("Проигрыш. Слово: " + secretWord);
        }
    }
}