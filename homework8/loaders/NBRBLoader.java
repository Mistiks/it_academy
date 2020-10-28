package homeworks.homework8.loaders;

import homeworks.homework8.utils.DateUtil;
import homeworks.homework8.utils.FileUtil;

import java.util.Calendar;

/**
 * Загрузчик курса с сайта Нац. Банка
 */
public class NBRBLoader extends SiteLoader {
    private final String fileName = "Currency_NBRB.txt";

    @Override
    public String getFileName() {
        return fileName;
    }

    /**
     * Метод для запуска загрузки курса валют
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    public String load(SiteLoader.Currency currencyName) {
        return load("https://www.nbrb.by/api/exrates/rates/" + currencyName.getId(), currencyName);
    }

    @Override
    public String loadDate(SiteLoader.Currency currencyName, Calendar calendar) {
        return load("https://www.nbrb.by/api/exrates/rates/" + currencyName.getId() + "?ondate="
                + calendar.get(Calendar.YEAR) + "-" + getCalendarMonth(calendar)
                + "-" + getCalendarDay(calendar), currencyName);
    }

    /**
     * Обработка результата загрузки с сайта банка
     * @param content то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected String handle(String content, SiteLoader.Currency currencyName) {
        int index = content.indexOf("Cur_OfficialRate");
        int dateIndex = content.indexOf("Date");
        index = content.indexOf(":", index);
        return "Date: " + content.substring(dateIndex + 7, dateIndex + 17) + " " + currencyName.getRatio()
                + " " + currencyName + " = " + content.substring(index + 1, index + 6) + " BYN" + "\n";
    }
}