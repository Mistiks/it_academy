package homeworks.homework5;

import java.util.*;

public class WarAndPeace{
    private final String filePath;
    private final String text;
    List<String> wordsList;

    public WarAndPeace(String filePath) {
        this.filePath = filePath;
        this.text = FileReader.readAllBytesJava7(getFilePath());
        this.wordsList = Arrays.asList(text.split("\\P{L}+"));
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getText() {
        return text;
    }

    public void printMostFrequentWords(int amount) {
        int count = 0;
        Map<String, Integer> wordsMap = new HashMap<>();

        for (String word : wordsList) {
            if (wordsMap.containsKey(word)) {
                int counter = wordsMap.get(word);
                counter++;
                wordsMap.put(word, counter);
            } else {
                wordsMap.put(word, 1);
            }
        }

        ValueComparator comparator = new ValueComparator(wordsMap);
        Map<String, Integer> sorted_map = new TreeMap<>(comparator);
        sorted_map.putAll(wordsMap);

        for (Map.Entry<String, Integer> entry:sorted_map.entrySet()) {
            if (count >= amount) {
                break;
            }

            System.out.println(returnCorrectString(entry.getValue(), entry.getKey()));
            count++;
        }
    }

    private String returnCorrectString(int number, String word) {
        String result = word + " - " + number;

        if (number % 10 >= 2 && number % 10 <= 4 &&
                (number % 100 < 10 || number  % 100 > 20 )) {
            return result + " раза";
        } else {
            return result + " раз";
        }
    }
}