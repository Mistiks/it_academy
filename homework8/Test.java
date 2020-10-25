package homeworks.homework8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String filePath;
        Scanner scanner = new Scanner(System.in);
        SiteLoader loaderNBRB = new NBRBLoader();
        SiteLoader loaderAlfa = new AlfaLoader();

        // Имя и расширение хранятся в классе, так что путь с клавиатуры должен заканчиваться символом "\"
        System.out.println("Введите путь к файлам. При неверном или пустом вводе файл будет создан в папке по умолчанию");
        filePath = scanner.nextLine();

        printRates(loaderNBRB, filePath);
        printRates(loaderAlfa, filePath);
    }

    /**
     * Метод для вывода курсов и их сохранения в файл
     * @param loader - экземпляр загрузчика сайтов
     * @param path - путь к файлу для записи
     */
    public static void printRates(SiteLoader loader, String path) {
        double currencyEUR = loader.load(SiteLoader.Currency.EUR);
        double currencyRUB = loader.load(SiteLoader.Currency.RUB);
        double currencyUSD = loader.load(SiteLoader.Currency.USD);
        StringBuilder builder = new StringBuilder();

        System.out.println("1 EUR = " + currencyEUR + " BYN");
        System.out.println("100 RUB = " + currencyRUB + " BYN");
        System.out.println("1 USD = " + currencyUSD + " BYN");

        // создание строки для печати в файл
        builder.append("1 EUR = ").append(currencyEUR).append(" BYN   ").append("100 RUB = ").append(currencyRUB)
                .append(" BYN   ").append("1 USD = ").append(currencyUSD).append(" BYN   ").append("\n");

        File file = new File(createFile(loader, path));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(builder.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод для создания файла, где хранятся курсы валют
     * @param loader - экземпляр загрузчика сайтов
     * @param path - путь, введенный с клавиатуры
     * @return путь к файлу
     */
    public static String createFile(SiteLoader loader, String path) {
        File f = new File(path + loader.getFileName());

        try { // попытка создания файла, используя указанный пользователем путь
            if (f.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл уже существует");
            }
        } catch (IOException e) { // путь неверный, создаём файл рядом с программой
            System.out.println(e.getMessage());
            f = new File(loader.getFileName());
            try {
                if (f.createNewFile()) {
                    System.out.println("Файл создан в директории по умолчанию");
                } else {
                    System.out.println("Файл уже существует в директории по умолчанию");
                }
            } catch (IOException error) {
                System.out.println(error.getMessage());
            }
        }
        return f.getPath();
    }
}