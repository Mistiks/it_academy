package homeworks.homework5;

public class EasySearch implements ISearchEngine {
    @Override
    public long search(String text, String word) {
        int index = 0;
        long amount = 0L;

        while(true) {
            index = text.indexOf(word, index);
            if (index == -1) {
                break;
            }

            if (index == 0 && word.length() == text.length()) { // строка и слово одинаковы
                amount++;
                break;
            } else if (index == 0) {  // если искомое слово - начало строки, и строка больше слова
                if (Character.isLetter(text.charAt(index + word.length()))) { // если искомое слово - часть другого слова
                    index++; // продолжаем поиск без увеличения счетчика
                } else {
                    amount++;
                    index++;
                }
            } else if (index + word.length() == text.length()) { // искомое слово - конец строки
                if (Character.isLetter(text.charAt(index - 1))) {
                    break;
                } else {
                    amount++;
                    break;
                }
            } else if (Character.isLetter(text.charAt(index + word.length())) ||
                    Character.isLetter(text.charAt(index - 1))) {
                index++;
            } else {
                amount++;
                index++;
            }
        }
        return amount;
    }
}