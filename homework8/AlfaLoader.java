package homeworks.homework8;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Загрузчик курса с сайта Альфа-Банка
 */
public class AlfaLoader extends SiteLoader {
    private final String fileName = "Currency_Alfa.txt";

    @Override
    public String getFileName() {
        return this.fileName;
    }

    /**
     * Метод для запуска загрузки курса валют
     *
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    public String load(SiteLoader.Currency currencyName) {
        return load("https://developerhub.alfabank.by:8273/partner/1.0.0/public/rates", currencyName);
    }

    @Override
    public String loadDate(SiteLoader.Currency currencyName, Calendar calendar) {
        return load("https://developerhub.alfabank.by:8273/partner/1.0.1/public/nationalRates?currencyCode="
                + currencyName.getAlfaId() + "&date=" + getCalendarDay()
                + "." + getCalendarMonth() + "." + calendar.get(Calendar.YEAR), currencyName);
    }

    /**
     * Обработка результата загрузки с сайта банка
     *
     * @param content      то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected String handle(String content, SiteLoader.Currency currencyName) {
        String searchString;
        Pattern pattern = Pattern.compile("\"sellCode\":" + currencyName.getAlfaId()
                + ",\"buyRate\":[0-9].[0-9]{6},\"buyIso\":\"BYN\"");
        Matcher matcher = pattern.matcher(content);
        Pattern pattern1 = Pattern.compile("[0-9].[0-9]{6}"); // формат ответа у архива другой
        Matcher matcher1 = pattern1.matcher(content);
        Pattern datePattern1 = Pattern.compile("[0-9]{2}.[0-9]{2}.[0-9].{4}");
        Matcher dateMatcher1 = datePattern1.matcher(content);

        if (matcher.find()) {
            searchString = content.substring(matcher.start(), matcher.end());
        } else {
            if (matcher1.find()) {
                searchString = content.substring(matcher1.start(), matcher1.end());
            } else {
                return "Курс не найден ";
            }
        }

        pattern = Pattern.compile("[0-9].[0-9]{2,6}"); // поиск курса типа double
        matcher = pattern.matcher(searchString);

        Pattern datePattern = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}"); // простой шаблон для поиска даты
        Matcher dateMatcher = datePattern.matcher(content);

        // Единообразие ответов от сервера Альфа-банка для слабых
        if (!dateMatcher.find()) {
            datePattern1 = Pattern.compile("[0-9]{2}.[0-9]{2}.[0-9].{4}");
            dateMatcher1 = datePattern1.matcher(content);
            if ((!dateMatcher1.find())) {
                return "Нет даты ";
            }
        }

        if (matcher.find() && dateMatcher.find()) { // вывод сегодняшних курсов
            return "Date: " + content.substring(dateMatcher.start(), dateMatcher.end()) + " "
                    + currencyName.getRatio() + " " + currencyName + " = "
                    + searchString.substring(matcher.start(), matcher.start() + 5) + " BYN\n";
        } else if (!matcher.find()) {
            return "Date: " + content.substring(dateMatcher1.start(), dateMatcher1.start() + 2) + "-"
                    + content.substring(dateMatcher1.start() + 3, dateMatcher1.start() + 5) + "-"
                    + content.substring(dateMatcher1.start() + 6, dateMatcher1.end() - 1) + " "
                    + currencyName.getRatio() + " " + currencyName + " = "
                    + searchString.substring(0, 5) + " BYN\n";
        }
        return "Курсы недоступны";
    }
}