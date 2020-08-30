package homeworks.homework1;

import java.util.Scanner;
import java.util.Objects;

public class OperatorsTask5First {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите своё имя: ");
        String name = input.nextLine();

        if (equals(name, "Вася")) {
            System.out.println("Привет!");
            System.out.println("Я так долго тебя ждал!");
        }

        if (equals(name, "Анастасия")) {
            System.out.println("Я так долго тебя ждал!");
        }

        if (!equals(name, "Вася") & !equals(name, "Анастасия")) {
            System.out.println("Добрый день, а вы кто?");
        }
    }

    static boolean equals(Object first, Object second) {
        return Objects.equals(first, second);
    }
}
