package homeworks.homework1;

import java.util.Scanner;

public class OperatorsTask6Keyboard {
    public static void main(String[] args) {
        int[] array = new int[10];
        String result;

        Scanner input = new Scanner(System.in);
        System.out.println("Введите 10 цифр номера:");

        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }

        result = OperatorsTask6.createPhoneNumber(array);
        System.out.println(result);
    }
}