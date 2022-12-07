package main;

public class SummOfMinimumValues {

    private static int[] values;
    private static int firstmin;
    private static int secondmin;

    //Конструктор исключает любые данные кроме int
    public SummOfMinimumValues(int[] array) {
        this.values = array;
        searchFirstMinValue();
        searchSecondMinValue();
    }

    //Ищем минимальное значение в массиве
    public static void searchFirstMinValue() {
        try {
            int min = values[0];
            for (int value : values) {
                if (value < min) {
                    min = value;
                }
            }
            firstmin = min;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Массив не должен быть пустым");
        }
    }

    //Ищем второе минимиальное значение
    public static void searchSecondMinValue() {
        int min = values[0];
        //Проверяем есть ли дубль первого минимального значения
        if (sameCheck()) {
            secondmin = firstmin;
            return;
        }
        for (int value : values) {
            if (value < min && value != firstmin) {
                min = value;
            }
        }
        secondmin = min;
    }

    //Проверяем есть ли дубль первого минимального значения
    public static boolean sameCheck() {
        int count = 0;
        for (int value : values) {
            if (value == firstmin) {
                count++;
            }
        }
        return count > 1;
    }

    public static int getFirstmin() {
        return firstmin;
    }

    public int getSecondmin() {
        return secondmin;
    }

    public static int getSummin() {
        return firstmin + secondmin;
    }
}
