package homeworks.homework4.runner;

import homeworks.homework4.entity.StringTask;

import java.util.Scanner;

public class StringTaskMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringTask stringTask = new StringTask();
        int number;
        long milliseconds;
        double doubleNumber;
        boolean format;

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

        System.out.println("Введите количество миллисекунд: ");
        milliseconds = input.nextLong();
        System.out.println("Введите формат вывода (true - короткий, false - полный): ");
        format = input.nextBoolean();
        System.out.println(stringTask.toHoursMinuteSecondMillisecond(milliseconds, format));
    }
}
