package src.com.lesson_2_3_4.array;

import java.util.concurrent.ThreadLocalRandom;

public class HackingSimulator {

    public static void main(String[] args) {
        System.out.print("Hacking: ");
        boolean granted = hack();
        printResult(granted);
    }

    private static boolean hack() {
        final char[] spins = {'-', '\\', '|', '/'};
        final int count = 3;
        final int delay = 300;
        int steps = count * spins.length;
        for (int i = 0; i < steps; i++) {
            char c = spins[i % spins.length];
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
            System.out.print("\b");
        }
        int marker = ThreadLocalRandom.current().nextInt(0, 101);
        return marker > 70;
    }

    private static void printResult(boolean granted) {
        final String GREEN = "\u001B[32m";
        final String RED = "\u001B[31m";
        final String RESET = "\u001B[0m";
        String msg = granted ? GREEN + "Access Granted!" + RESET
                : RED + "Access Denied!" + RESET;
        System.out.print(msg);
    }
}
