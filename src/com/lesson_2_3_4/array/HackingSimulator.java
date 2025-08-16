package src.com.lesson_2_3_4.array;

import java.util.concurrent.ThreadLocalRandom;

public class HackingSimulator {
    private static final char[] SYMBOLS = {'-', '\\', '|', '/'};
    private static final int COUNT = 3;
    private static final int DELAY_MS = 500;
    private static final int TRESHHOLD = 70;
    private static final String LABEL = "Hacking: ";
    private static final String GRANTED_MSG = "\u001B[32mAccess granted!\u001B[0m";
    private static final String DENIED_MSG = "\u001B[31mAccess denied!\u001B[0m";

    public static void main(String[] args) {
        simulator();
    }

    public static void simulator() {
        for (int i = 0; i < COUNT; i++) {
            for (char c : SYMBOLS) {
                System.out.print("\r" + LABEL + c);
                try {
                    Thread.sleep(DELAY_MS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Поток прерван!");
                    return;
                }
            }
            System.out.print("\r");
        }
        int result = ThreadLocalRandom.current().nextInt(101);
        if (result > TRESHHOLD) {
            System.out.println(GRANTED_MSG);
        } else {
            System.out.println(DENIED_MSG);
        }
    }
}
