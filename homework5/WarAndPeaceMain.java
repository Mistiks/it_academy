package homeworks.homework5;

import java.util.Scanner;

public class WarAndPeaceMain {
    public static void main(String[] args) {
        WarAndPeace warAndPeace = new WarAndPeace("D:/Programs/Java course/it_academy/src/homeworks" +
                                                            "/homework5/Война и мир_книга.txt");
        EasySearch easySearch = new EasySearch();
        Scanner scanner = new Scanner(System.in);
        String searchWord;
        char doubleQuotes = (char) 34;

        warAndPeace.createWordsSet(FileReader.readAllBytesJava7(warAndPeace.getFilePath()));
        warAndPeace.createWordsMap(FileReader.readAllBytesJava7(warAndPeace.getFilePath()));
        //System.out.println(warAndPeace.getWordsSet());
        //System.out.println(warAndPeace.getWordsMap());
        warAndPeace.printMostFrequentWords(10);

        System.out.print("Введите строку для поиска: ");
        searchWord = scanner.nextLine();
        System.out.println("Количество строк " + doubleQuotes + searchWord + doubleQuotes +  " в тексте: " +
                easySearch.search(FileReader.readAllBytesJava7(warAndPeace.getFilePath()), searchWord));

        System.out.println("Количество слов " + doubleQuotes + "война" + doubleQuotes + " в тексте: " +
                warAndPeace.searchWordRegisterFree("война"));
        System.out.println("Количество слов " + doubleQuotes + "и" + doubleQuotes + " в тексте: " +
                warAndPeace.searchWordRegisterFree("и"));
        System.out.println("Количество слов " + doubleQuotes + "мир" + doubleQuotes + " в тексте: " +
                warAndPeace.searchWordRegisterFree("мир"));
    }
}
