package homeworks.homework1;

public class OperatorsTask4 {
    public static void main(String[] args) {
        boolean isSleep = sleepIn(true, false); // Результат - false, в остальных случаях - true

        if (isSleep) {
            System.out.println("Можем спать дальше");
        } else {
            System.out.println("Пора собираться на работу");
        }
    }

    static boolean sleepIn(boolean weekday, boolean vacation) {
        return !weekday || vacation;
    }
}
