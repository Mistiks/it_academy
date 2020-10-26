package homeworks.homework8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
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

        //printRates(loaderNBRB, filePath, args, loaderNBRB.calendar);
        printRates(loaderAlfa, filePath, args, loaderAlfa.calendar);
    }

    /**
     * Метод для вывода курсов и их сохранения в файл
     * @param loader - экземпляр загрузчика сайтов
     * @param path - путь к файлу для записи
     */
    public static void printRates(SiteLoader loader, String path, String[] date, Calendar calendar) {
        String currencyEUR = loader.load(SiteLoader.Currency.EUR);
        String currencyRUB = loader.load(SiteLoader.Currency.RUB);
        String currencyUSD = loader.load(SiteLoader.Currency.USD);
        StringBuilder builder = new StringBuilder();

        System.out.print(currencyEUR);
        System.out.print(currencyRUB);
        System.out.print(currencyUSD);

        // создание строки для печати в файл
        builder.append(currencyEUR).append(currencyRUB).append(currencyUSD);

        if (date.length == 1 && isDateValid(date[0], loader)) {
            currencyEUR = loader.loadDate(SiteLoader.Currency.EUR, loader.calendar);
            currencyRUB = loader.loadDate(SiteLoader.Currency.RUB, loader.calendar);
            currencyUSD = loader.loadDate(SiteLoader.Currency.USD, loader.calendar);
            System.out.print(currencyEUR);
            System.out.print(currencyRUB);
            System.out.print(currencyUSD);
            builder.append(currencyEUR).append(currencyRUB).append(currencyUSD);
        }

        File file = new File(loader.createFile(loader, path));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(builder.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод для проверки валидности даты, указанной через аргумент к командной строке и записи её в класс
     * @param testDate - дата для проверки
     * @return является ли дата валидной для дальнейшней работы
     */
    public static boolean isDateValid(String testDate, SiteLoader loader) { ;
        DateTimeFormatter f = DateTimeFormatter.ofPattern ("yyyy-MM-dd");
        try {
            LocalDate date = LocalDate.parse(testDate,f);
            loader.setCurrentCalendar(localDateToCalendar(date));
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    /**
     * Метод для преобразования LocalDate в Calendar
     * @param localDate - дата для преобразования
     * @return календарь
     */
    public static Calendar localDateToCalendar(LocalDate localDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(localDate.getYear(), localDate.getMonthValue()-1, localDate.getDayOfMonth());
        return calendar;
    }
}