package homeworks.homework5;

public class EasySearch implements ISearchEngine {
    @Override
    public long search(String text, String word) {
        int index = 0;
        long amount = 0L;

        while(index != -1) {
            index = text.indexOf(word, index);
            if (index != -1) {
                amount++;
                index++;
            }
        }
        return amount;
    }
}