package src.com.lesson_2_3_4.calculator;

public class Calculator {
    public double calculate(int firstNum, char operator, int secondNum) {
        switch (operator) {
            case '+':
                return firstNum + secondNum;
            case '-':
                return firstNum - secondNum;
            case '*':
                return firstNum * secondNum;
            case '/':
                if (secondNum == 0) {
                    throw new ArithmeticException("Ошибка: деление на ноль запрещено");
                }
                return firstNum / secondNum;
            case '%':
                if (secondNum == 0) {
                    throw new ArithmeticException("Ошибка: деление на ноль запрещено");
                }
                return firstNum % secondNum;
            case '^':
                return Math.pow(firstNum, secondNum);

            default:
                throw new IllegalArgumentException("Оператор " + operator + " не поддерживается");
        }
    }
}
