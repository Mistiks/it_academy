package homeworks.homework5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExSearch implements ISearchEngine {
    @Override
    public long search(String text, String word) {
        long amount = 0L;
        String regex = "\\b"+word+"\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()) {
            amount++;
        }
        return amount;
    }
}
