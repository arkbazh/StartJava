package src.com.lesson_1.base;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        // ==================================
        // 1. ПЕРЕВОД ПСЕВДОКОДА НА ЯЗЫК JAVA
        // ==================================
        System.out.println("1. ПЕРЕВОД ПСЕВДОКОДА НА ЯЗЫК JAVA");
        boolean man = true;
        if (man) {
            System.out.println("He is a man");
        } else {
            System.out.println("She is a woman");
        }
        byte age = 19;
        if (age > 18) {
            System.out.println("Adult");
        } else {
            System.out.println("Teen");
        }
        double height = 1.79;
        if (height < 1.8) {
            System.out.println("Height < 1.8");
        } else {
            System.out.println("Height > 1.8");
        }
        char firstNameChar = "Tom".charAt(0);
        if (firstNameChar == 'M') {
            System.out.println("First char of name: " + "M");
        } else if (firstNameChar == 'I') {
            System.out.println("First char of name: " + "I");
        } else {
            System.out.println("First char of name not \"M\" or \"I\"" + "\n");
        }

        // =======================
        // 2. ПОИСК БОЛЬШЕГО ЧИСЛА
        // =======================
        System.out.println("2. ПОИСК БОЛЬШЕГО ЧИСЛА");
        int first = 23;
        int second = 42;
        if (first < second) {
            System.out.println(first + " меньше " + second + "\n");
        } else if (second < first) {
            System.out.println(second + " больше " + first);
        } else {
            System.out.println(first + " и " + second + " равны " + "\n");
        }

        // =======================
        // 3. ПРОВЕРКА ЧИСЛА
        // =======================
        System.out.println("3. ПРОВЕРКА ЧИСЛА");
        int number = 10;
        if (number == 0) {
            System.out.println(number + " равно нулю ");
        } else {
            String sign = number < 0 ? "отрицательным" : "положительным";
            String parity = number % 2 == 0 ? "четным" : "нечетным";
            System.out.println(number + " является " + sign + " и " + parity + "\n");
        }

        // =================================
        // 4. ПОИСК ОДИНАКОВЫХ ЦИФР В ЧИСЛАХ
        // =================================
        System.out.println("4. ПОИСК ОДИНАКОВЫХ ЦИФР В ЧИСЛАХ");
        int x = 123;
        int y = 223;
        int hundredX = x / 100;
        int tenX = (x % 100) / 10;
        int onesX = x % 10;
        int hundredY = y / 100;
        int tenY = (y % 100) / 10;
        int onesY = y % 10;
        if (hundredX != hundredY && tenX != tenY && onesX != onesY) {
            System.out.println("В переменных нет равных разрядов" + "\n");
        } else {
            if (hundredX == hundredY) {
                System.out.println("Одинаковые цифры в разряде сотен: " + hundredX);
            }
            if (tenX == tenY) {
                System.out.println("Одинаковые цифры в разряде десяток: " + tenX);
            }
            if (onesX == onesY) {
                System.out.println("Одинаковые цифры в разряде единиц: " + onesX);
            }
            System.out.println();
        }

        // ==================================
        // 5. ОПРЕДЕЛЕНИЕ СИМВОЛА ПО ЕГО КОДУ
        // ==================================
        System.out.println("5. ОПРЕДЕЛЕНИЕ СИМВОЛА ПО ЕГО КОДУ");
        char unknownChar = '\u0057';
        if (unknownChar >= 'A' && unknownChar <= 'Z') {
            System.out.println("'" + unknownChar + "'  - большая буква" + "\n");
        } else if (unknownChar >= 'a' && unknownChar <= 'z') {
            System.out.println("'" + unknownChar + "'  - маленькая буква" + "\n");
        } else if (unknownChar >= '0' && unknownChar <= '9') {
            System.out.println("'" + unknownChar + "'  - цифра" + "\n");
        } else {
            System.out.println("'" + unknownChar + "'  - ни буква ни цифра" + "\n");
        }

        // ==================================
        // 6. ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ %
        // ==================================
        System.out.println("6. ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ %");
        double deposit = 321123.59;
        double interestRate = 0.05;
        if (deposit >= 100000 && deposit <= 300000) {
            interestRate = 0.07;
        } else if (deposit > 300000) {
            interestRate = 0.1;
        }
        double interestAmount = deposit * interestRate;
        double finalAmount = deposit + interestAmount;
        System.out.println("Сумма вклада: " + deposit);
        System.out.printf("Сумма начисленного:  %.2f%n", interestAmount);
        System.out.printf("Итоговая сумма: %.2f%n", finalAmount);
        System.out.println();

        // ==================================
        // 7. ОПРЕДЕЛЕНИЕ ОЦЕНКИ ПО ПРЕДМЕТАМ
        // ==================================
        System.out.println("7. ОПРЕДЕЛЕНИЕ ОЦЕНКИ ПО ПРЕДМЕТАМ");
        int historyPercent = 59;
        int programmingPercent = 92;
        int historyGrade = 2;
        int programmingGrade = 2;

        if (historyPercent > 91) {
            historyGrade = 5;
        } else if (historyPercent > 73) {
            historyGrade = 4;
        } else if (historyPercent > 60) {
            historyGrade = 3;
        }
        if (programmingPercent > 91) {
            programmingGrade = 5;
        } else if (programmingPercent > 73) {
            programmingGrade = 4;
        } else if (programmingPercent > 60) {
            programmingGrade = 3;
        }
        double averageGrade = (historyGrade + programmingGrade) / 2;
        double averagePercent = (historyPercent + programmingPercent) / 2;
        System.out.println("История: " + programmingGrade);
        System.out.println("Программирование: " + historyGrade);
        System.out.println("Средний балл оценок по предметам: " + averageGrade);
        System.out.println("Средний процент по предметам: " + averagePercent + "\n");

        // ==================================
        // 8. РАСЧЕТ ГОДОВОЙ ПРИБЫЛИ
        // ==================================
        System.out.println("8. РАСЧЕТ ГОДОВОЙ ПРИБЫЛИ");
        double mounthlySales = 13025.233;
        double rent = 5123.018;
        double costPrice = 9001.729;
        double yearProfit = 12 * (mounthlySales - rent - costPrice);
        String sign = yearProfit > 0 ? "+" : yearProfit < 0 ? "-" : "";
        System.out.printf("Прибыль за год: %s%.2f%n", sign, Math.abs(yearProfit));
    }
}
