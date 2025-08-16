package src.com.lesson_2_3_4.method.naming;

public class Main {
    public static void main(String[] args) {
        execBooleanMethods();
        execNonBooleanMethods();
    }

    public static void execBooleanMethods() {
        BooleanMethods bm = new BooleanMethods();
        System.out.println(bm.isProgramRunning());
        System.out.println(bm.isFileDeleted());
        System.out.println(bm.containsUniqueDigit());
        System.out.println(bm.isLetter());
        System.out.println(bm.hasEqualsDigits());
        System.out.println(bm.isBlank());
        System.out.println(bm.isEvenRoll());
        System.out.println(bm.isValidFilePath());
        System.out.println(bm.fileExists());
        System.out.println(bm.hasAttemptsLeft());
        System.out.println();
    }

    public static void execNonBooleanMethods() {
        NonBooleanMethods nonBm = new NonBooleanMethods();
        nonBm.findBookByAuthor();
        nonBm.findLongestWord();
        nonBm.celsiusToFahrenheit();
        nonBm.calculateAverageGrade();
        nonBm.countUniqueWords();
        nonBm.enterMathExpression();
        nonBm.identifyWinner();
        nonBm.displayErrorMessage();
        nonBm.pauseDownload();
        nonBm.resetToFactoryDefaults();
        nonBm.restoreFromBackup();
        nonBm.syncWithCloud();
        nonBm.selectMenuItem();
        nonBm.writeToFile();
        System.out.println();
    }
}
