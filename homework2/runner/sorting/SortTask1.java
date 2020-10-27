package homeworks.homework2.runner.sorting;

import homeworks.homework2.service.comparator.IntegerComparator;
import homeworks.homework2.utils.ArrayConverter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortTask1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfElements = 0;
        int[] testArray1 = new int[] {1, 2, 3, 4, 5, 6};
        int[] testArray2 = new int[] {1, 1, 1, 1};
        int[] testArray3 = new int[] {9, 1, 5, 99, 9, 9};
        int[] testArray4 = new int[] {};
        boolean inputFlag = false;

        System.out.println("Первый тестовый массив до сортировки: " + Arrays.toString(testArray1));
        System.out.println("Первый тестовый массив после сортировки пузырьком: " + Arrays.toString(bubbleSort(testArray1)));
        shakerSort(testArray1);
        System.out.println("Первый тестовый массив после шейкерной сортировки: " + Arrays.toString(testArray1));
        System.out.println("Второй тестовый массив до сортировки: " + Arrays.toString(testArray2));
        System.out.println("Второй тестовый массив после сортировки пузырьком: " + Arrays.toString(bubbleSort(testArray2)));
        shakerSort(testArray2);
        System.out.println("Второй тестовый массив после шейкерной сортировки: " + Arrays.toString(testArray2));
        System.out.println("Третий тестовый массив до сортировки: " + Arrays.toString(testArray3));
        System.out.println("Третий тестовый массив после сортировки пузырьком: " + Arrays.toString(bubbleSort(testArray3)));
        shakerSort(testArray3);
        System.out.println("Третий тестовый массив после шейкерной сортировки: " + Arrays.toString(testArray3));
        System.out.println("Четвертый тестовый массив до сортировки: " + Arrays.toString(testArray4));
        System.out.println("Четвертый тестовый массив после сортировки пузырьком: " + Arrays.toString(bubbleSort(testArray4)));
        shakerSort(testArray4);
        System.out.println("Четвертый тестовый массив после шейкерной сортировки: " + Arrays.toString(testArray4));

        int randomLength = (int) (Math.random() * 20 + 5); // размер массива от 5 до 25 элементов
        int[] randomArray = new int[randomLength];

        for (int i = 0; i < randomArray.length - 1; i++) {
            randomArray[i] = (int) (Math.random() * 100); // значения элементов массива от 0 до 100
        }

        System.out.println("Рандомный массив до сортировки: " + Arrays.toString(randomArray));
        System.out.println("Рандомный массив после сортировки пузырьком: " + Arrays.toString(bubbleSort(randomArray)));
        shakerSort(randomArray);
        System.out.println("Рандомный массив после шейкерной сортировки: " + Arrays.toString(randomArray));

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

        System.out.println("Массив, введенный с консоли, до сортировки: " + Arrays.toString(array));
        System.out.println("Массив, введенный с консоли, после сортировки пузырьком: " + Arrays.toString(bubbleSort(array)));
        shakerSort(array);
        System.out.println("Массив, введенный с консоли, после шейкерной сортировки: " + Arrays.toString(array));
    }

    public static int[] bubbleSort(int[] inputArray) {
        Integer[] array;
        ArrayConverter converter = new ArrayConverter();
        IntegerComparator comparator = new IntegerComparator();

        array = converter.intToInteger(inputArray);
        bubbleSort(array, comparator);
        return converter.integerToInt(array);
    }

    public static void shakerSort(int[] inputArray) {
        int temp;
        int leftBorder = 0;
        int rightBorder = inputArray.length - 1;
        boolean isSorted = false;

        while(!isSorted) {
            isSorted = true;

            for (int i = 0; i < rightBorder; i++) {
                if (inputArray[i] > inputArray[i + 1]) {
                    temp = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = temp;
                    isSorted = false;
                }
            }

            rightBorder--;

            for (int i = rightBorder; i > leftBorder; i--) {
                if (inputArray[i] < inputArray[i + 1]) {
                    temp = inputArray[i];
                    inputArray[i] = inputArray[i - 1];
                    inputArray[i - 1] = temp;
                    isSorted = false;
                }
            }

            leftBorder++;
        }
    }

    public static <T> void bubbleSort(T[] inputArray, Comparator<T> comparator) {
        T temp;
        boolean isSorted = false;

        while(!isSorted) {
            isSorted = true;

            for (int i = 0; i < inputArray.length - 1; i++) {
                if (comparator.compare(inputArray[i], inputArray[i + 1]) > 0) {
                    temp = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
    }
}
