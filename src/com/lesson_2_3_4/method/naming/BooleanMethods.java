package src.com.lesson_2_3_4.method.naming;

public class BooleanMethods {
    public boolean isProgramRunning() {
        System.out.print(Util.getCurrName() +
                "() -> программа выполняется далее или завершается? ");
        return true;
    }

    public boolean isFileDeleted() {
        System.out.print(Util.getCurrName() +
                "() -> удалился ли файл на жестком диске или флешке? ");
        return true;
    }

    public boolean containsUniqueDigit() {
        System.out.print(Util.getCurrName() +
                "() -> последовательность содержит уникальную цифру? ");
        return true;
    }

    public boolean isLetter() {
        System.out.print(Util.getCurrName() +
                "() -> пользователь ввел букву или что-то другое? ");
        return true;
    }

    public boolean hasEqualsDigits() {
        System.out.print(Util.getCurrName() +
                "() -> в проверяемых числах, есть равные цифры? ");
        return true;
    }

    public boolean hasAttemptsLeft() {
        System.out.print(Util.getCurrName() +
                "() -> в игре \"Марио\" остались попытки? ");
        return true;
    }

    public boolean isBlank() {
        System.out.print(Util.getCurrName() +
                "() -> пользователь ввёл пустую строку или из одних пробелов? ");
        return true;
    }

    public boolean isEvenRoll() {
        System.out.print(Util.getCurrName() +
                "() -> на кубике, который бросил компьютер, выпало четное число? ");
        return true;
    }

    public boolean isValidFilePath() {
        System.out.print(Util.getCurrName() +
                "() -> путь до файла, который вы ищите на ssd, действительный? ");
        return true;
    }

    public boolean fileExists() {
        System.out.print(Util.getCurrName() +
                "() -> файл по указанному адресу существует? ");
        return true;
    }
}
