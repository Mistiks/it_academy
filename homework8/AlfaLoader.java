package homeworks.homework8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Загрузчик курса с сайта Альфа-Банка
 */
public class AlfaLoader extends SiteLoader{
    private final String fileName = "Currency_Alfa.txt";

    @Override
    public String getFileName() {
        return this.fileName;
    }

    /**
     * Метод для запуска загрузки курса валют
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    public double load(SiteLoader.Currency currencyName) {
        return load("https://developerhub.alfabank.by:8273/partner/1.0.0/public/rates", currencyName);
    }

    /**
     * Обработка результата загрузки с сайта банка
     * @param content то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected double handle(String content, SiteLoader.Currency currencyName) {
        String searchString;
        Pattern pattern = Pattern.compile("\"sellCode\":" + currencyName.getAlfaId()
                                            + ",\"buyRate\":[0-9].[0-9]+,\"buyIso\":\"BYN\"");
        Matcher matcher = pattern.matcher(content);

        if (matcher.find()) {
            searchString = content.substring(matcher.start(), matcher.end());
        } else {
            return -10; // "курс" , если банк поменяет структуру строки
        }

        pattern = Pattern.compile("[0-9].[0-9]{2,6}+"); // поиск курса типа double
        matcher = pattern.matcher(searchString);

        if (matcher.find()) {
            return Double.parseDouble(searchString.substring(matcher.start(), matcher.end()));
        } else {
            return -11; // ошибка при получении курса в заготовленной строке
        }
    }
}