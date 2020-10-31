package homeworks.homework8.utils;

import homeworks.homework8.loaders.SiteLoader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {

    /**
     * Метод для проверки валидности даты, указанной через аргумент к командной строке и записи её в класс
     * @param testDate - дата для проверки
     * @return является ли дата валидной для дальнейшней работы
     */
    public boolean isDateValid(String testDate, SiteLoader loader) { ;
        DateTimeFormatter f = DateTimeFormatter.ofPattern ("dd.MM.yyyy");
        List<String> allMatches = new ArrayList<>();

        Matcher matcher = Pattern.compile("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}").matcher(testDate);
        while (matcher.find()) {
            allMatches.add(matcher.group());
        }

        if (allMatches.size() == 0) { // в аргументе нет валидной даты
            return false;
        }

        try {
            LocalDate firstDate = LocalDate.parse(allMatches.get(0),f);

            if (allMatches.size() == 2) { // если указан диапазон дат
                LocalDate secondDate = LocalDate.parse(allMatches.get(1),f);
                if (secondDate.isBefore(firstDate)) { // диапазон в неправильном порядке
                    loader.setFirstDate(localDateToCalendar(secondDate));
                    loader.setSecondDate(localDateToCalendar(firstDate));
                } else {
                    loader.setFirstDate(localDateToCalendar(firstDate));
                    loader.setSecondDate(localDateToCalendar(secondDate));
                }
            }
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    /**
     * Метод для преобразования LocalDate в Calendar
     * @param localDate - дата для преобразования
     * @return календарь
     */
    public Calendar localDateToCalendar(LocalDate localDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(localDate.getYear(), localDate.getMonthValue()-1, localDate.getDayOfMonth());
        return calendar;
    }
}
