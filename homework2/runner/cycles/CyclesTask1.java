package homeworks.homework2.runner.cycles;

public class CyclesTask1 {
    public static void main(String[] args) {
        int number;
        long result = 1L;

        try {
            number = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Невозможно преобразовать аргумент в число. Программа будет остановлена.");
            return;
        }

        if (number < 1 || number > 20) {
            System.out.println("Число находится вне поддерживаемого диапазона. Программа будет остановлена.");
            return;
        }

        for (int i = 1; i <= number; i++) { // перемножаем числа от 1 до полученного
            result *= i;
        }

        for (int i = 1; i < number ; i++) {
            System.out.print(i + " * ");
        }

        System.out.print(number + " = " + result);
    }
}
