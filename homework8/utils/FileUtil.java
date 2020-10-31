package homeworks.homework8.utils;

import homeworks.homework4.entity.DataContainer;
import homeworks.homework8.loaders.SiteLoader;
import homeworks.homework8.service.comparator.DataContainerComparator;

import java.io.*;
import java.util.Calendar;

public class FileUtil {
    DateUtil dateUtil = new DateUtil();

    /*
    Вообще, тут можно было бы с тем же успехом использовать TreeSet (что позволило бы, кстати, избавиться от одинаковых
    строк при повторных запросах к тем же датам, что DataContainer не делает), но почему бы и не воспользоваться разок
    собственным готовым инструментом? К тому же сейчас есть возможность узнать, сколько раз происходила загрузка
    конкретного курса в конкретный день
     */
    DataContainer<String> container = new DataContainer<>(String.class, 0);
    DataContainerComparator comparator = new DataContainerComparator();

    /**
     * Метод для вывода курсов и их сохранения в файл
     * @param loader - экземпляр загрузчика сайтов
     * @param path - путь к файлу для записи
     */
    public void printRates(SiteLoader loader, String path, String[] date) {
        String currencyEUR = loader.load(SiteLoader.Currency.EUR);
        String currencyRUB = loader.load(SiteLoader.Currency.RUB);
        String currencyUSD = loader.load(SiteLoader.Currency.USD);

        container.add(currencyEUR);
        container.add(currencyRUB);
        container.add(currencyUSD);

        System.out.print(currencyEUR);
        System.out.print(currencyRUB);
        System.out.print(currencyUSD);

        if (date.length == 1 && dateUtil.isDateValid(date[0], loader)) {
            while(loader.getFirstDate().compareTo(loader.getSecondDate()) <= 0) {
                currencyEUR = loader.loadDate(SiteLoader.Currency.EUR, loader.getFirstDate());
                currencyRUB = loader.loadDate(SiteLoader.Currency.RUB, loader.getFirstDate());
                currencyUSD = loader.loadDate(SiteLoader.Currency.USD, loader.getFirstDate());

                container.add(currencyEUR);
                container.add(currencyRUB);
                container.add(currencyUSD);

                System.out.print(currencyEUR);
                System.out.print(currencyRUB);
                System.out.print(currencyUSD);

                loader.getFirstDate().add(Calendar.DATE, 1);
            }
        }

        File file = new File(createFile(loader, path));
        container.sort(comparator);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            for (int i = 0; i < container.getElementsCounter(); i++) {
                writer.write(container.get(i));
            }

            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод для создания файла, где хранятся курсы валют и считывания имеющихся данных в DataContainer
     * @param loader - экземпляр загрузчика сайтов
     * @param path - путь, введенный с клавиатуры
     * @return путь к файлу
     */
    public String createFile(SiteLoader loader, String path) {
        File f = new File(path + loader.getFileName());

        try { // попытка создания файла, используя указанный пользователем путь
            if (f.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл уже существует");

                try(FileReader fileReader = new FileReader(f)) {
                    BufferedReader reader = new BufferedReader(fileReader);
                    String line = reader.readLine();

                    while (line != null) {
                        container.add(line + "\n");
                        line = reader.readLine();
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) { // путь неверный, создаём файл рядом с программой
            System.out.println(e.getMessage());

            f = new File(loader.getFileName());
            try {
                if (f.createNewFile()) {
                    System.out.println("Файл создан в директории по умолчанию");
                } else {
                    System.out.println("Файл уже существует в директории по умолчанию");

                    try(FileReader fileReader = new FileReader(f)) {
                        BufferedReader reader = new BufferedReader(fileReader);
                        String line = reader.readLine();

                        while (line != null) {
                            container.add(line + "\n");
                            line = reader.readLine();
                        }
                    } catch (IOException exception) {
                        System.out.println(exception.getMessage());
                    }
                }
            } catch (IOException error) {
                System.out.println(error.getMessage());
            }
        }
        return f.getPath();
    }
}