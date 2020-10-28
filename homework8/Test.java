package homeworks.homework8;

import homeworks.homework8.loaders.AlfaLoader;
import homeworks.homework8.loaders.NBRBLoader;
import homeworks.homework8.loaders.SiteLoader;
import homeworks.homework8.utils.FileUtil;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String filePath;
        Scanner scanner = new Scanner(System.in);
        FileUtil fileUtil = new FileUtil();
        SiteLoader loaderNBRB = new NBRBLoader();
        SiteLoader loaderAlfa = new AlfaLoader();

        // Имя и расширение хранятся в классе, так что путь с клавиатуры должен заканчиваться символом "\"
        System.out.println("Введите путь к файлам. При неверном или пустом вводе файл будет создан в папке по умолчанию");
        filePath = scanner.nextLine();

        fileUtil.printRates(loaderNBRB, filePath, args);
        fileUtil.printRates(loaderAlfa, filePath, args);
    }
}