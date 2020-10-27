package homeworks.homework2.runner.cycles;

public class CyclesTask2 {
    public static void main(String[] args) {
        int number;
        int numberCopy;
        int amountOfDigits = 0;
        long result = 1L;

        try {
            number = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Невозможно преобразовать аргумент в число. Программа будет остановлена.");
            return;
        }

        numberCopy = number;

        while (numberCopy > 0) { // вычисляем количество разрядов числа
            numberCopy /= 10;
            amountOfDigits++;
        }

        int[] arrayOfDigits = new int[amountOfDigits];

        for (int i = 0; i < amountOfDigits; i++) { // получаем значение каждого разряда
            arrayOfDigits[amountOfDigits - 1 - i] = number % 10;
            number /= 10;
        }

        for (int i = 0; i < amountOfDigits; i++) { // перемножаем цифры разрядов
            result *= arrayOfDigits[i];
        }

        for (int i = 0; i < amountOfDigits - 1; i++) {
            System.out.print(arrayOfDigits[i] + " * ");
        }

        System.out.print(arrayOfDigits[amountOfDigits - 1] + " = " + result);
    }
}
