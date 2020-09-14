package homeworks.homework2;

import java.util.Scanner;

public class ArraysTask1 {
    public static void main(String[] args) {
        int numberOfElements = 0;
        int counter = 0;
        boolean inputFlag = false;
        Scanner input = new Scanner(System.in);

        System.out.println("Введите размер массива: ");

        do {
            if (!input.hasNextInt()) {
                System.out.println("Неверный ввод. Повторите попытку: ");
                input.next();
            } else {
                numberOfElements = input.nextInt();
                if (numberOfElements <= 0) {
                    System.out.println("Неверный ввод. Повторите попытку: ");
                } else {
                    inputFlag = true;
                }
            }
        } while(!inputFlag);

        int[] array = new int[numberOfElements];
        System.out.println("Введите элементы массива: ");

        for (int i = 0; i < numberOfElements; i++) {
            inputFlag = false;

            do {
                if (!input.hasNextInt()){
                    System.out.println("Неверный ввод. Повторите попытку: ");
                    input.next();
                } else {
                    array[i] = input.nextInt();
                    inputFlag = true;
                }
            } while (!inputFlag);
        }

        System.out.print("Вывод элементов массива с помощью do...while: ");

        do {
            System.out.print(array[counter] + " ");
            counter++;
        } while(counter < array.length);

        counter = 0;
        System.out.println();
        System.out.print("Вывод элементов массива с помощью while: ");

        while (counter < array.length) {
            System.out.print(array[counter] + " ");
            counter++;
        }

        System.out.println();
        System.out.print("Вывод элементов массива с помощью for: ");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
        System.out.print("Вывод элементов массива с помощью foreach: ");

        for (int i: array) {
            System.out.print(i + " ");
        }
    }
}

