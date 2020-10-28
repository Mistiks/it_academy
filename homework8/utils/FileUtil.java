package homeworks.homework8.utils;

import homeworks.homework8.loaders.SiteLoader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class FileUtil {

    DateUtil dateUtil = new DateUtil();

    /**
     * Метод для вывода курсов и их сохранения в файл
     * @param loader - экземпляр загрузчика сайтов
     * @param path - путь к файлу для записи
     */
    public void printRates(SiteLoader loader, String path, String[] date) {
        String currencyEUR = loader.load(SiteLoader.Currency.EUR);
        String currencyRUB = loader.load(SiteLoader.Currency.RUB);
        String currencyUSD = loader.load(SiteLoader.Currency.USD);
        StringBuilder builder = new StringBuilder();

        System.out.print(currencyEUR);
        System.out.print(currencyRUB);
        System.out.print(currencyUSD);

        // создание строки для печати в файл
        builder.append(currencyEUR).append(currencyRUB).append(currencyUSD);

        if (date.length == 1 && dateUtil.isDateValid(date[0], loader)) {
            while(loader.getFirstDate().compareTo(loader.getSecondDate()) <= 0) {
                currencyEUR = loader.loadDate(SiteLoader.Currency.EUR, loader.getFirstDate());
                currencyRUB = loader.loadDate(SiteLoader.Currency.RUB, loader.getFirstDate());
                currencyUSD = loader.loadDate(SiteLoader.Currency.USD, loader.getFirstDate());
                System.out.print(currencyEUR);
                System.out.print(currencyRUB);
                System.out.print(currencyUSD);
                builder.append(currencyEUR).append(currencyRUB).append(currencyUSD);
                loader.getFirstDate().add(Calendar.DATE, 1);
            }
        }

        File file = new File(loader.createFile(loader, path));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(builder.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
