package homeworks.homework8.loaders;

import homeworks.homework4.entity.DataContainer;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

/**
 * Реализация загрузчика сайтов
 */
public abstract class SiteLoader {

    public enum Currency{
        USD("145", 840, 1),
        EUR("292", 978, 1),
        RUB("298", 643, 100);

        private final String id;
        private final int alfaId;
        private final int ratio;

        Currency(String id, int alfaId, int ratio) {
            this.id = id;
            this.alfaId = alfaId;
            this.ratio = ratio;
        }

        public String getId(){
            return this.id;
        }

        public int getAlfaId() {
            return this.alfaId;
        }

        public int getRatio() {
            return this.ratio;
        }
    }

    private Calendar firstDate;
    private Calendar secondDate;

    private DataContainer<String> container;

    public void setFirstDate(Calendar firstDate) {
        this.firstDate = firstDate;
    }

    public void setSecondDate(Calendar secondDate) {
        this.secondDate = secondDate;
    }

    public Calendar getFirstDate() {
        return firstDate;
    }

    public Calendar getSecondDate() {
        return secondDate;
    }

    // Этот метод создан при поддержке API Альфа-банка, которое не принимает 6 как месяц, а требует обязательно 06
    public String getCalendarMonth(Calendar calendar) {
        if (calendar.get(Calendar.MONTH) < 9) {
            return "0" + (calendar.get(Calendar.MONTH) + 1);
        } else {
            return "" + calendar.get(Calendar.MONTH);
        }
    }

    //Этот метод создан при поддержке API Альфа-банка, которое не принимает 6 как день, а требует обязательно 06
    public String getCalendarDay(Calendar calendar) {
        if (calendar.get(Calendar.DAY_OF_MONTH) < 10) {
            return "0" + calendar.get(Calendar.DAY_OF_MONTH);
        } else {
            return "" + calendar.get(Calendar.DAY_OF_MONTH);
        }
    }

    /**
     * Метод для запуска загрузки курса валют
     * @param urlToSite урл по которому надо постучаться
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    protected final String load(String urlToSite, SiteLoader.Currency currencyName){

        StringBuilder content;
        boolean error;
        int retryCount = 0;
        do{
            content = new StringBuilder();
            error = false;
            try {
                // create a url object
                HttpURLConnection con = (HttpURLConnection) new URL(urlToSite).openConnection();

                con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:47.0) Gecko/20100101 Firefox/47.0");
                con.setConnectTimeout(50000); //set timeout to 50 seconds
                con.setReadTimeout(50000); //set timeout to 50 seconds

                try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()))){
                    String line;
                    while ((line = bufferedReader.readLine()) != null)
                    {
                        content.append(line).append("\n");
                    }
                }
            }
            catch(Exception e)
            {
                error = true;
                retryCount++;
                System.err.println("При соединении что-то пошло не так. "  + e.getMessage());
            }
        } while (error && retryCount < 5);

        if(error){
            throw new RuntimeException("Не получилось загрузить курсы валют");
        }
        return handle(content.toString(), currencyName);
    }

    public abstract String load(SiteLoader.Currency currencyName);

    /**
     * Метод который будет дёрнут после успешной загрузки сайта
     * @param content содержимое сайта
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    protected abstract String handle(String content, SiteLoader.Currency currencyName);

    public abstract String getFileName();

    public abstract String loadDate(SiteLoader.Currency currencyName, Calendar calendar);
}