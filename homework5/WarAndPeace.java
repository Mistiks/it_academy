package homeworks.homework5;

import java.util.*;
import java.util.Map.Entry;

public class WarAndPeace {
    private String filePath;
    private HashSet<String> wordsSet;
    private Map<String, Integer> wordsMap;
    private List<String> wordsList;

    public WarAndPeace(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public HashSet<String> getWordsSet() {
        return this.wordsSet;
    }

    public Map<String, Integer> getWordsMap() {
        return this.wordsMap;
    }

    public void createWordsSet(String text) {
        this.wordsSet = new HashSet<String>(Arrays.asList(text.split("\\P{L}+")));
    }

    public void createWordsMap(String text) { // ключ - строка, значение - количество повторений
        this.wordsList = Arrays.asList(text.split("\\P{L}+"));
        this.wordsMap = new HashMap<String, Integer>();

        for (int i = 0; i < wordsList.size(); i++) {
            if (wordsMap.containsKey(wordsList.get(i))) {
                int counter = wordsMap.get(wordsList.get(i));
                counter++;
                wordsMap.put(wordsList.get(i), counter);
            } else {
                wordsMap.put(wordsList.get(i), 1);
            }
        }
    }

    public void printMostFrequentWords(int amount) {
        List<Entry<String, Integer>> sortingList = new LinkedList<Entry<String, Integer>>(wordsMap.entrySet());

        sortingList.sort(new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();

        for (Entry<String, Integer> entry : sortingList)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        List<Entry<String, Integer>> outputList = new LinkedList<Entry<String, Integer>>(sortedMap.entrySet());

        for (int i = 0; i < amount; i++) {
            if (outputList.get(i).getValue() % 10 >= 2 && outputList.get(i).getValue() % 10 <= 4 &&
                    (outputList.get(i).getValue() % 100 < 10 || outputList.get(i).getValue()  % 100 > 20 )) {
                System.out.println(outputList.get(i).getKey() + " - " + outputList.get(i).getValue() + " раза");
            } else {
                System.out.println(outputList.get(i).getKey() + " - " + outputList.get(i).getValue() + " раз");
            }
        }
    }

    public long searchWordRegisterFree(String word) {
        long amount = 0L;

        if (wordsMap.containsKey(word.substring(0,1).toUpperCase() + word.substring(1))) {
            amount += wordsMap.get(word.substring(0,1).toUpperCase() + word.substring(1));
        }

        if (wordsMap.containsKey(word.substring(0,1).toLowerCase() + word.substring(1))) {
            amount += wordsMap.get(word.substring(0,1).toLowerCase() + word.substring(1));
        }
        return amount;
    }
}
