package src.com.lesson_1.final_;

public class Calculator {
    private int a;
    private char sign;
    private int b;

    public void setA(int a) {
        this.a = a;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void calculate() {
        double result;
        switch (sign) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '^':
                result = pow();
                break;
            case '/':
            case '%':
                if (b == 0) {
                    System.out.println("Ошибка: деление на ноль запрещено");
                    return;
                }
                result = divOrMod();
                break;
            default:
                System.out.println("Ошибка: операция '" + sign + "' не поддерживается");
                return;
        }
        System.out.println(a + " " + sign + " " + b + " = " + result);
    }

    private double pow() {
        double result = 1;
        for (int i = 0; i < Math.abs(b); i++) {
            result *= a;
        }
        return b >= 0 ? result : 1 / result;
    }

    private double divOrMod() {
        return (sign == '/' ? (double) a / b : a % b);
    }
}
