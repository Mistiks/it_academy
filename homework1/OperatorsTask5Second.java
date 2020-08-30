package homeworks.homework1;

import java.util.Objects;
import java.util.Scanner;

public class OperatorsTask5Second {
    public static void main(String[] args) {
        String firstName = "Вася";
        String secondName = "Анастасия";

        Scanner input = new Scanner(System.in);
        System.out.print("Введите своё имя: ");
        String name = input.nextLine();

        if (equals(name, firstName)) {
            System.out.println("Привет!");
            System.out.println("Я так долго тебя ждал!");
        } else if (equals(name, secondName)) {
            System.out.println("Я так долго тебя ждал!");
        } else if (!equals(name, firstName) & !equals(name, secondName)) {
            System.out.println("Добрый день, а вы кто?");
        }
    }

    static boolean equals(Object first, Object second) {
        return Objects.equals(first, second);
    }
}
