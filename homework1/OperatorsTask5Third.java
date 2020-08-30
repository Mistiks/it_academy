package homeworks.homework1;

import java.util.Scanner;

public class OperatorsTask5Third {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите своё имя: ");
        String name = input.nextLine();

        switch (name) {
            case "Вася": System.out.println("Привет!");
                System.out.println("Я так долго тебя ждал!");
                break;
            case "Анастасия": System.out.println("Я так долго тебя ждал!");
                break;
            default: System.out.println("Добрый день, а вы кто?");
                break;
        }
    }
}
