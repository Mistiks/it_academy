package homeworks.homework2;

import java.util.Scanner;

public class ArraysTask3 {
    public static void main(String[] args) {
        int numberOfElements = 0;
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
        int[] arrayReverse = new int[numberOfElements];
        int counter = numberOfElements;
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

        System.out.print("Вывод элементов массива в обратном порядке с помощью do...while: ");

        do {
            System.out.print(array[counter - 1] + " ");
            counter--;
        } while(counter > 0);

        counter = numberOfElements;
        System.out.println();
        System.out.print("Вывод элементов массива в обратном порядке с помощью while: ");

        while (counter > 0) {
            System.out.print(array[counter - 1] + " ");
            counter--;
        }

        System.out.println();
        System.out.print("Вывод элементов массива в обратном порядке с помощью for: ");

        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
            arrayReverse[counter] = array[i];
            counter++;
        }

        System.out.println();
        System.out.print("Вывод элементов массива в обратном порядке с помощью foreach: ");

        for (int i: arrayReverse) {
            System.out.print(i + " ");
        }
    }
}

