package homeworks.homework4;

import java.util.Scanner;

public class StringTaskMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringTask stringTask = new StringTask();
        int number;
        double doubleNumber;

        System.out.println("Введите целое число, которое нужно представить прописью: ");
        number = input.nextInt();
        System.out.println("Число прописью: " + stringTask.toString(number));

        System.out.println("Введите дробное число, которое нужно представить прописью: ");
        doubleNumber = input.nextDouble();
        System.out.println("Число прописью: " + stringTask.toString(doubleNumber));
        stringTask.setSecondType(false);

        System.out.println("Введите число дней: ");
        number = input.nextInt();
        System.out.println(stringTask.toWeek(number));
    }
}
