package homeworks.homework2;

import java.util.Scanner;

public class CyclesTask3 {
    public static void main(String[] args) {
        double number = 0;
        double result = 1;
        int degree = 0;
        boolean inputFlag = false;
        Scanner input = new Scanner(System.in);

        System.out.println("Введите число:");

        do {
            if (!input.hasNextDouble()){
                System.out.println("Неверный ввод. Повторите попытку: ");
                input.nextLine();
            } else {
                number = input.nextDouble();
                inputFlag = true;
            }
        } while (!inputFlag);

        System.out.println("Введите положительную целую степень числа: ");
        inputFlag = false;

        do {
            if (!input.hasNextInt()) {
                System.out.println("Неверный ввод. Повторите попытку: ");
                input.nextLine();
            } else {
                degree = input.nextInt();
                if (degree <= 0) {
                    System.out.println("Неверный ввод. Повторите попытку: ");
                } else {
                    inputFlag = true;
                }
            }
        } while (!inputFlag);

        for (int i = 0; i < degree; i++) {
            result = result * number;
        }

        System.out.println("Результат возведения в степень: " + result);
    }
}
