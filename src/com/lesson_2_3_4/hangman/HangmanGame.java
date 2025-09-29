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
            "| GAME OVER!"};
    private static final String[] DICTIONARY = {"чай", "англия", "агент", "работа", "игра"};
    private static final int LIVES = GALLOWS.length;
    private static final Pattern CYRILLIC_PATTERN = Pattern.compile("[а-яёА-ЯЁ]");

    private final Scanner scanner = new Scanner(System.in);
    private char[] mask;
    private int mistakes;
    private String secretWord;
    private String usedLetters;
    private String wrongLetters;

    void play() {
        do {
            System.out.println("Игра начинается.");
            resetStatsForNewRound();
            while (!isWin() && !isLose()) {
                char guess = readUsersGuess();
                addUsedLetters(guess);
                boolean hit = revealLetterInMask(guess);
                if (hit) {
                    onHit();
                } else {
                    onMiss(guess);
                }
                printGameState();
            }
            printResult();
        } while (askReplay());
    }

    private void resetStatsForNewRound() {
        secretWord = DICTIONARY[ThreadLocalRandom.current().nextInt(0, DICTIONARY.length)];
        mask = "*".repeat(secretWord.length()).toCharArray();
        mistakes = 0;
        usedLetters = "";
        wrongLetters = "";
    }

    private char readUsersGuess() {
        String s;
        do {
            System.out.print("Введите букву: ");
            s = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
            if (s.isEmpty()) {
                System.out.println("Ввод не может быть пустым");
                continue;
            }
            if (usedLetters.contains(s)) {
                System.out.println("Буква уже была использована.");
                continue;
            }
            if (!CYRILLIC_PATTERN.matcher(s).matches()) {
                System.out.println("Должна быть одна буква кириллицы");
                continue;
            }
            break;
        } while (true);
        return s.charAt(0);
    }

    private void addUsedLetters(char guess) {
        usedLetters += guess;
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
        if (wrongLetters.indexOf(guess) < 0) {
            wrongLetters += guess;
        }
        mistakes++;
    }

    private void printGameState() {
        for (int i = 0; i < Math.min(mistakes, GALLOWS.length); i++) {
            System.out.println(GALLOWS[i]);
        }

        System.out.println(new String(mask));

        System.out.println("Неверные буквы: " + wrongLetters);

        int livesLeft = Math.max(0, LIVES - mistakes);
        System.out.println("Осталось попыток: " + livesLeft + ". Всего попыток: " + LIVES + ".");
    }

    private boolean isWin() {
        for (char c : mask) {
            if (c == '*') {
                return false;
            }
        }
        return true;
    }

    private boolean isLose() {
        if (mistakes >= LIVES) {
            return true;
        }
        return false;
    }

    private void printResult() {
        if (isWin()) {
            System.out.println("Победа! Слово: " + secretWord);
        }
        if (isLose()) {
            System.out.println("Проигрыш. Слово: " + secretWord);
        }
    }

    private boolean askReplay() {
        String answer;
        while (true) {
            System.out.println("Играть заново? введите: yes/no");
            answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase("yes")) {
                return true;
            } else if (answer.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println("Некорректный ввод. Введите только yes или no.");
            }
        }
    }
}