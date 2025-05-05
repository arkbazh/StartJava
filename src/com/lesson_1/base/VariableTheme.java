package src.com.lesson_1.base;

public class VariableTheme {
    public static void main(String[] args) {
        // =================================
        // 1. ВЫВОД ХАРАКТЕРИСТИК КОМПЬЮТЕРА
        // =================================
        System.out.println("1. ВЫВОД ХАРАКТЕРИСТИК КОМПЬЮТЕРА");
        byte usbPortCount = 4;
        System.out.println("Количество USB портов: " + usbPortCount);
        short cpuCoreCount = 16;
        System.out.println("Количество ядер: " + cpuCoreCount);
        int ramCapacity = 100_663_296;
        System.out.println("Объем оперативной памяти в кб: " + ramCapacity);
        long hddCapacity = 2_147_483_648L;
        System.out.println("Объем жесткого диска в кб: " + hddCapacity);
        float cpuFrequency = 3.6f;
        System.out.println("Частота процессора: " + cpuFrequency);
        double screenRefreshRate = 60.0;
        System.out.println("Частота обновления экрана: " + screenRefreshRate);
        boolean hasSsd = true;
        System.out.println("Есть SSD? " + hasSsd);
        char energyClass = 'A';
        System.out.println("Класс энергопотребления:" + energyClass + "\n");

        // =====================================
        // 2. РАСЧЕТ СТОИМОСТИ ТОВАРА СО СКИДКОЙ
        // =====================================================
        System.out.println("2. РАСЧЕТ СТОИМОСТИ ТОВАРА СО СКИДКОЙ");
        double penPrice = 105.5;
        System.out.println("Стоимость ручки: " + penPrice);
        double bookPrice = 235.83;
        System.out.println("Стоимость книги: " + bookPrice);
        double discountPercent = 11;
        System.out.println("Скидка в процентах: " + discountPercent);
        double basePrice = penPrice + bookPrice;
        basePrice = Math.round(basePrice * 100.0) / 100;
        System.out.println("Общая стоимость товара: " + basePrice);
        double discountSum = basePrice * (discountPercent / 100);
        discountSum = Math.round(discountSum * 100.0) / 100;
        System.out.println("Сумма скидки: " + discountSum);
        double discountPrice = basePrice - discountSum;
        discountPrice = Math.round(discountPrice * 100.0) / 100;
        System.out.println("Общая стоимость товара со скидкой: " + discountPrice + "\n");

        // ==================================
        // 3. ВЫВОД СЛОВА JAVA БЕЗ ПЕРЕМЕННЫХ
        // ==================================
        System.out.println("3. ВЫВОД СЛОВА JAVA");
        System.out.println("   J    a  v     v  a");
        System.out.println("   J   a a  v   v  a a");
        System.out.println("J  J  aaaaa  V V  aaaaa");
        System.out.println(" JJ  a     a  V  a     a");
        System.out.println();

        // ================================================
        // 4. ВЫВОД MIN И MAX ЗНАЧЕНИЙ ЦЕЛЫХ ЧИСЛОВЫХ ТИПОВ
        // ================================================
        System.out.println("4. ВЫВОД MIN И MAX ЗНАЧЕНИЙ ЦЕЛЫХ ЧИСЛОВЫХ ТИПОВ");
        byte maxByte = 127;
        System.out.println("Первоначальное значение: " + maxByte);
        System.out.println("Инкрементируем на 1: " + ++maxByte);
        System.out.println("Декрементируем на 1: " + --maxByte);
        short maxShort = 32_767;
        System.out.println("Первоначальное значение : " + maxShort);
        System.out.println("Инкрементируем на 1: " + ++maxShort);
        System.out.println("Декрементируем на 1: " + --maxShort);
        int maxInt = 2_147_483_647;
        System.out.println("Первоначальное значение: " + maxInt);
        System.out.println("Инкрементируем на 1: " + ++maxInt);
        System.out.println("Декрементируем на 1: " + --maxInt);
        long maxLong = 9_223_372_036_854_775_807L;
        System.out.println("Первоначальное значение : " + maxLong);
        System.out.println("Инкрементируем на 1: " + ++maxLong);
        System.out.println("Декрементируем на 1: " + --maxLong);
        char maxChar = 65_535;
        System.out.println("Первоначальное значение: " + (int) maxChar);
        System.out.println("Инкрементируем на 1. Переполнение и обнуление: " + (int) ++maxChar);
        System.out.println("Декрементируем на 1: " + (int) --maxChar + "\n");

        // ===================================
        // 5. ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ПЕРЕМЕННЫХ
        // ===================================
        System.out.println("5. ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ПЕРЕМЕННЫХ");
        System.out.println("Вариант 1. Меняем местами значения переменныx с помощью третьей переменной");
        int a = 2;
        int b = 5;
        System.out.println("Исходное значение перменной a: " + a);
        System.out.println("Исходное значение перменной b: " + b);
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println("Новое значение переменной a: " + a);
        System.out.println("Новое значение переменной b: " + b);
        System.out.println("Варинт 2. Меняем местами переменные с помощью арифметических операций");
        a += b;
        b = a - b;
        a -= b;
        System.out.println("Новое значение переменной a: " + a);
        System.out.println("Новое значение переменной b: " + b);
        System.out.println("Вариант 3. Меняем местами переменные с помощью побитовой операции");
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("Новое значение переменной a: " + a);
        System.out.println("Новое значение переменной b: " + b + "\n");

        // ============================
        // 6. ВЫВОД СИМВОЛОВ И ИХ КОДОВ
        // ============================
        System.out.println("6. ВЫВОД СИМВОЛОВ И ИХ КОДОВ");
        char dollarSign = '$';
        System.out.println("Код символа: " + (int) dollarSign + " Символ: $");
        char asterisk = '*';
        System.out.println("Код символа: " + (int) asterisk + " Символ: *");
        char atSign = '@';
        System.out.println("Код символа: " + (int) atSign + " Символ: @");
        char caret = '^';
        System.out.println("Код символа: " + (int) caret + " Символ: ^");
        char tilde = '~';
        System.out.println("Код символа: " + (int) tilde + " Символ: ~" + "\n");

        // =================================
        // 7. ВЫВОД В КОНСОЛЬ ASCII-АРТ ДЮКА
        // =================================
        System.out.println("7. ВЫВОД В КОНСОЛЬ ASCII-АРТ ДЮКА");
        char slash = '/';
        char backslash = '\\';
        char underscore = '_';
        char leftParenthesis = '(';
        char rightParenthesis = ')';
        System.out.println("    " + slash + backslash);
        System.out.println("   " + slash + "  " + backslash);
        System.out.println("  " + slash + underscore + leftParenthesis + " " + rightParenthesis + backslash);
        System.out.println(" " + slash + "      " + backslash);
        System.out.println(slash + "" + underscore + underscore + underscore + underscore + slash +
                backslash + underscore + underscore + backslash + "\n");

        // =====================================================
        // 8. МАНИПУЛЯЦИИ С СОТНЯМИ, ДЕСЯТКАМИ И ЕДИНИЦАМИ ЧИСЛА
        // =====================================================
        System.out.println("8. МАНИПУЛЯЦИИ С СОТНЯМИ, ДЕСЯТКАМИ И ЕДИНИЦАМИ ЧИСЛА");
        int num = 123;
        int hundreds = num / 100;
        int tens = (num / 10) % 10;
        int ones = num % 10;
        System.out.println("Число " + num + " содержит: ");
        System.out.println("Сотен - " + hundreds);
        System.out.println("Десятков - " + tens);
        System.out.println("Единиц - " + ones);
        System.out.println("Сумма разрядов = " + (hundreds + tens + ones));
        System.out.println("Произведение разрядов = " + (hundreds * tens * ones) + "\n");

        // =====================================================
        // 9. ПЕРЕВОД СЕКУНД В ЧАСЫ, МИНУТЫ И СЕКУНДЫ
        // =====================================================
        System.out.println("9. ПЕРЕВОД СЕКУНД В ЧАСЫ, МИНУТЫ И СЕКУНДЫ");
        int totalSeconds = 86399;
        int hh = totalSeconds / 3600;
        int mm = (totalSeconds % 3600) / 60;
        int ss = totalSeconds % 60;
        System.out.println(hh + ":" + mm + ":" + ss + "\n");
    }
}
