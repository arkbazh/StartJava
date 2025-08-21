package src.com.lesson_2_3_4.array;

import java.util.concurrent.ThreadLocalRandom;

public class HackingSimulator {

    public static void main(String[] args) {
        System.out.print("Hacking: ");
        boolean granted = hack();
        printAccess(granted);
    }

    private static boolean hack() {
        final char[] spins = {'-', '\\', '|', '/'};
        int steps = 3 * spins.length;
        for (int i = 0; i < steps; i++) {
            char c = spins[i % spins.length];
            System.out.print("\b" + c);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        return ThreadLocalRandom.current().nextInt(101) > 70;
    }

    private static void printAccess(boolean granted) {
        final String green = "\u001B[32m";
        final String red = "\u001B[31m";
        final String reset = "\u001B[0m";
        if (granted) {
            System.out.print("\b" + green + "Access Granted!" + reset);
        } else {
            System.out.print("\b" + red + "Access Denied!" + reset);
        }
    }
}
