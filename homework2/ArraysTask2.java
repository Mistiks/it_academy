package homeworks.homework2;

import java.util.Scanner;

public class ArraysTask2 {
    public static void main(String[] args) {
        int numberOfElements = 0;
        int counter = 0;
        boolean inputFlag = false;
        Scanner input = new Scanner(System.in);

        System.out.println("Введите размер массива: ");

        do {
            if (!input.hasNextInt()) {
                System.out.println("Неверный ввод. Повторите попытку: ");
                input.nextLine();
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
                    input.nextLine();
                } else {
                    array[i] = input.nextInt();
                    inputFlag = true;
                }
            } while (!inputFlag);
        }

        System.out.print("Вывод каждого второго элемента массива: ");

        for (int i = 0; i < numberOfElements; i++) {
            if ((i + 1) % 2 == 0) {
                System.out.print(array[i] + " ");
            }
        }
    }
}

