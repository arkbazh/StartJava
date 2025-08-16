package src.com.lesson_2_3_4.method.naming;

public class Util {
    private Util() {
    }

    public static String getCurrName() {
        return new Throwable().getStackTrace()[1].getMethodName();
    }
}
