package homeworks.homework5;

import java.util.Scanner;

public class WarAndPeaceMain {
    public static void main(String[] args) {
        EasySearch easySearch = new EasySearch();
        RegExSearch regExSearch = new RegExSearch();
        WarAndPeace warAndPeace = new WarAndPeace("D:/Programs/Java course/it_academy/src/homeworks" +
                                                                "/homework5/Война и мир_книга.txt");
        Scanner scanner = new Scanner(System.in);
        String searchWord;
        char doubleQuotes = (char) 34;

        warAndPeace.printMostFrequentWords(10);

        System.out.print("Введите строку для поиска: ");
        searchWord = scanner.nextLine();
        System.out.println("Количество слов " + doubleQuotes + searchWord + doubleQuotes +  " в тексте (indexOf): " +
                easySearch.search((warAndPeace.getText()), searchWord));

        System.out.println();
        System.out.println("Поиск слов без учета регистра:");
        System.out.println("Количество слов " + doubleQuotes + "война" + doubleQuotes + " в тексте: " +
                easySearch.search((warAndPeace.getText()),"война"));
        System.out.println("Количество слов " + doubleQuotes + "и" + doubleQuotes + " в тексте: " +
                easySearch.search((warAndPeace.getText()),"и"));
        System.out.println("Количество слов " + doubleQuotes + "мир" + doubleQuotes + " в тексте: " +
                regExSearch.search((warAndPeace.getText()),"мир"));
    }
}