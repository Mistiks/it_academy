package homeworks.homework4;

public class StringTask {
    private final String[] digits = new String[]{ "один ", "два ", "три ", "четыре ", "пять ", "шесть ", "семь ",
            "восемь ", "девять "};
    private final String[] digitsSecondCase = new String[]{ "одна ", "две ", "три ", "четыре ", "пять ", "шесть ", "семь ",
            "восемь ", "девять "};
    private final String[] secondDozen = new String[]{ "десять ", "одиннадцать ", "двенадцать ", "тринадцать ",
            "четырнадцать ", "пятнадцать ", "шестнадцать ", "семнадцать ",
            "восемнадцать ", "девятнадцать "};
    private final String[] dozens = new String[]{ "десять ", "двадцать ", "тридцать ", "сорок ", "пятьдесят ",
            "шестьдесят ", "семьдесят ", "восемьдесят ", "девяносто "};
    private final String[] hundreds = new String[]{ "сто ", "двести ", "триста ", "четыреста ", "пятьсот ", "шестьсот ",
            "семьсот ", "восемьсот ", "девятьсот "};
    private final String[] thousandsCases = new String[]{ "тысяча ", "тысячи ", "тысяч "};
    private final String[] millionCases = new String[]{ "миллион ", "миллиона ", "миллионов "};
    private boolean secondType = false;

    public void setSecondType(boolean secondType) {
        this.secondType = secondType;
    }

    public String toString(int number) {

        if (number < 0) {
            return "Минус " + toString(-number).toLowerCase();
        }

        if (number < 1000 && !secondType) {
            return prescriptionToThousand(number);
        } else if ( number < 1000) {
            return prescriptionToThousandSecond(number);
        } else if (number < 10000) {
            return prescriptionToTenThousand(number);
        } else if (number < 20000) {
            return prescriptionToTwentyThousand(number);
        } else if (number < 100000) {
            return prescriptionToHundredThousand(number);
        } else if (number < 1000000) {
            return prescriptionToOneMillion(number);
        } else if (number < 10000000) {
            return prescriptionToTenMillion(number);
        } else if ( number < 19999999) {
            return prescriptionToTwentyMillions(number);
        } else if (number < 99999999) {
            return prescriptionToHundredMillions(number);
        } else {
            return prescriptionToOneBillion(number);
        }

    }

    /**
     * Метод преобразозывает в пропись числа от 0 до 999 включительно
     * Внимание: метод всегда возвращает пропись, начиная с заглавной буквы
     * @param number - число для преобразования
     * @return String - сумма прописью
     */
    private String prescriptionToThousand(int number) {

        if (number > 999) {
            return prescriptionToTenThousand(number);
        }

        if (number == 0) {
            return "Ноль ";
        } else if (number > 0 && number < 10) {
            return digits[number - 1].substring(0, 1).toUpperCase() + digits[number - 1].substring(1);
        } else if (number > 9 && number < 20) {
            return secondDozen[number - 10].substring(0, 1).toUpperCase() + secondDozen[number - 10].substring(1);
        } else if (number > 19 && number < 100) {
            if (number % 10 - 1 >= 0) {
                return dozens[number / 10 - 1].substring(0, 1).toUpperCase() + dozens[number / 10 - 1].substring(1)
                        + digits[number % 10 - 1];
            } else {
                return dozens[number / 10 - 1].substring(0, 1).toUpperCase() + dozens[number / 10 - 1].substring(1);
            }
        } else {
            if (number % 100 == 0) {
                return hundreds[number / 100 - 1].substring(0, 1).toUpperCase() + hundreds[number / 100 - 1].substring(1);
            } else if (number % 10 == 0) {
                return hundreds[number / 100 - 1].substring(0, 1).toUpperCase() + hundreds[number / 100 - 1].substring(1)
                        + dozens[(number % 100) / 10 - 1];
            } else if (number % 100 >= 10 && number % 100 < 20) {
                return hundreds[number / 100 - 1].substring(0, 1).toUpperCase() + hundreds[number / 100 - 1].substring(1)
                        + secondDozen[number % 100 - 10];
            } else if ((number % 100) / 10 - 1 >= 0){
                return hundreds[number / 100 - 1].substring(0, 1).toUpperCase() + hundreds[number / 100 - 1].substring(1)
                        + dozens[(number % 100) / 10 - 1] + digits[number % 10 - 1];
            } else {
                return hundreds[number / 100 - 1].substring(0, 1).toUpperCase() + hundreds[number / 100 - 1].substring(1)
                        + digits[number % 10 - 1];
            }
        }
    }

    /**
     * Метод преобразозывает в пропись числа от 0 до 999 включительно
     * Внимание: метод всегда возвращает пропись, начиная с заглавной буквы
     * Разница с предыдущим методом в выводе единиц для второго задания
     * @param number - число для преобразования
     * @return String - сумма прописью
     */
    private String prescriptionToThousandSecond(int number) {

        if (number > 999) {
            return prescriptionToTenThousand(number);
        }

        if (number == 0) {
            return "Ноль";
        } else if (number > 0 && number < 10) {
            return digitsSecondCase[number - 1].substring(0, 1).toUpperCase() + digitsSecondCase[number - 1].substring(1);
        } else if (number > 9 && number < 20) {
            return secondDozen[number - 10].substring(0, 1).toUpperCase() + secondDozen[number - 10].substring(1);
        } else if (number > 19 && number < 100) {
            if (number % 10 - 1 >= 0) {
                return dozens[number / 10 - 1].substring(0, 1).toUpperCase() + dozens[number / 10 - 1].substring(1)
                        + digitsSecondCase[number % 10 - 1];
            } else {
                return dozens[number / 10 - 1].substring(0, 1).toUpperCase() + dozens[number / 10 - 1].substring(1);
            }
        } else {
            if (number % 100 == 0) {
                return hundreds[number / 100 - 1].substring(0, 1).toUpperCase() + hundreds[number / 100 - 1].substring(1);
            } else if (number % 10 == 0) {
                return hundreds[number / 100 - 1].substring(0, 1).toUpperCase() + hundreds[number / 100 - 1].substring(1)
                        + dozens[(number % 100) / 10 - 1];
            } else if (number % 100 >= 10 && number % 100 < 20) {
                return hundreds[number / 100 - 1].substring(0, 1).toUpperCase() + hundreds[number / 100 - 1].substring(1)
                        + secondDozen[number % 100 - 10];
            } else if ((number % 100) / 10 - 1 >= 0){
                return hundreds[number / 100 - 1].substring(0, 1).toUpperCase() + hundreds[number / 100 - 1].substring(1)
                        + dozens[(number % 100) / 10 - 1] + digitsSecondCase[number % 10 - 1];
            } else {
                return hundreds[number / 100 - 1].substring(0, 1).toUpperCase() + hundreds[number / 100 - 1].substring(1)
                        + digitsSecondCase[number % 10 - 1];
            }
        }
    }

    /**
     * Метод преобразозывает в пропись числа от 1000 до 9999 включительно
     * Внимание: метод всегда возвращает пропись, начиная с заглавной буквы
     * @param number - число для преобразования
     * @return String - сумма прописью
     */
    private String prescriptionToTenThousand(int number) {

        if (number < 1000 && !secondType) {
            return prescriptionToThousand(number);
        } else if (number < 1000){
            return prescriptionToThousandSecond(number);
        }

        if (number > 9999) {
            return prescriptionToTwentyThousand(number);
        }

            if (number / 1000 - 1 == 0 && number % 1000 != 0 && !secondType) {
                return digitsSecondCase[0].substring(0, 1).toUpperCase() + digitsSecondCase[0].substring(1)
                        + thousandsCases[0] + prescriptionToThousand(number % 1000).toLowerCase();
            } else if (number / 1000 - 1 == 0 && number % 1000 != 0 && secondType) {
                return digitsSecondCase[0].substring(0, 1).toUpperCase() + digitsSecondCase[0].substring(1)
                        + thousandsCases[0] + prescriptionToThousandSecond(number % 1000).toLowerCase();
            } else if (number / 1000 - 1 == 0 && number % 1000 == 0) {
                return digitsSecondCase[0].substring(0, 1).toUpperCase() + digitsSecondCase[0].substring(1)
                        + thousandsCases[0];
            } else if (number / 1000 - 1 > 0 && number / 1000 - 1 < 4) {
                if (number % 1000 == 0) {
                    return digitsSecondCase[number / 1000 - 1].substring(0, 1).toUpperCase()
                            + digitsSecondCase[number / 1000 - 1].substring(1) + thousandsCases[1];
                } else if (number % 1000 != 0 && !secondType){
                    return digitsSecondCase[number / 1000 - 1].substring(0, 1).toUpperCase()
                            + digitsSecondCase[number / 1000 - 1].substring(1) + thousandsCases[1]
                            + prescriptionToThousand(number % 1000).toLowerCase();
                } else {
                    return digitsSecondCase[number / 1000 - 1].substring(0, 1).toUpperCase()
                            + digitsSecondCase[number / 1000 - 1].substring(1) + thousandsCases[1]
                            + prescriptionToThousandSecond(number % 1000).toLowerCase();
                }
            } else if (number / 1000 - 1 >= 4) {
                if (number % 1000 == 0) {
                    return digitsSecondCase[number / 1000 - 1].substring(0, 1).toUpperCase()
                            + digitsSecondCase[number / 1000 - 1].substring(1) + thousandsCases[2];
                } else if (number % 1000 != 0 && !secondType) {
                    return digitsSecondCase[number / 1000 - 1].substring(0, 1).toUpperCase()
                            + digitsSecondCase[number / 1000 - 1].substring(1) + thousandsCases[2]
                            + prescriptionToThousand(number % 1000).toLowerCase();
                } else {
                    return digitsSecondCase[number / 1000 - 1].substring(0, 1).toUpperCase()
                            + digitsSecondCase[number / 1000 - 1].substring(1) + thousandsCases[1]
                            + prescriptionToThousandSecond(number % 1000).toLowerCase();
                }
            }
        return "Ошибка в вычиcлениях";
    }

    /**
     * Метод преобразозывает в пропись числа от 10000 до 19999 включительно
     * Внимание: метод всегда возвращает пропись, начиная с заглавной буквы
     * @param number - число для преобразования
     * @return String - сумма прописью
     */
    private String prescriptionToTwentyThousand(int number) {

        if (number < 10000) {
            return prescriptionToTenThousand(number);
        }

        if (number > 20000) {
            return prescriptionToHundredThousand(number);
        }

        if (number % 1000 == 0) {
            return secondDozen[number / 1000 - 10].substring(0, 1).toUpperCase()
                    + secondDozen[number / 1000 - 10].substring(1) + thousandsCases[2];
        } else if (number % 1000 != 0 && !secondType){
            return secondDozen[number / 1000 - 10].substring(0, 1).toUpperCase()
                    + secondDozen[number / 1000 - 10].substring(1) + thousandsCases[2]
                    + prescriptionToThousand(number % 1000).toLowerCase();
            } else {
            return secondDozen[number / 1000 - 10].substring(0, 1).toUpperCase()
                    + secondDozen[number / 1000 - 10].substring(1) + thousandsCases[2]
                    + prescriptionToThousandSecond(number % 1000).toLowerCase();
        }
    }

    /**
     * Метод преобразозывает в пропись числа от 20000 до 99999 включительно
     * Внимание: метод всегда возвращает пропись, начиная с заглавной буквы
     * @param number - число для преобразования
     * @return String - сумма прописью
     */
    private String prescriptionToHundredThousand(int number) {

        if (number < 20000) {
            return prescriptionToTwentyThousand(number);
        }

        if (number > 99999) {
            return prescriptionToOneMillion(number);
        }

        if (number % 10000 == 0) {
            return dozens[number / 10000 - 1].substring(0, 1).toUpperCase()
                    + dozens[number / 10000 - 1].substring(1) + thousandsCases[2];
        } else {
            return dozens[number / 10000 - 1].substring(0, 1).toUpperCase()
                    + dozens[number / 10000 - 1].substring(1)
                    + prescriptionToTenThousand(number - 10000 * (number / 10000)).toLowerCase();
        }
    }

    /**
     * Метод преобразозывает в пропись числа от 100000 до 999999 включительно
     * Внимание: метод всегда возвращает пропись, начиная с заглавной буквы
     * @param number - число для преобразования
     * @return String - сумма прописью
     */
    private String prescriptionToOneMillion(int number) {

        if (number < 100000) {
            return prescriptionToHundredThousand(number);
        }

        if (number > 999999) {
            return prescriptionToTenMillion(number);
        }

        if (number % 100000 == 0) {
            return hundreds[number / 100000 - 1].substring(0, 1).toUpperCase()
                    + hundreds[number / 100000 - 1].substring(1) + thousandsCases[2];
        } else return hundreds[number / 100000 - 1].substring(0, 1).toUpperCase()
                    + hundreds[number / 100000 - 1].substring(1) + prescriptionToHundredThousand(number % 100000).toLowerCase();
    }

    /**
     * Метод преобразозывает в пропись числа от 1000000 до 9999999 включительно
     * Внимание: метод всегда возвращает пропись, начиная с заглавной буквы
     * @param number - число для преобразования
     * @return String - сумма прописью
     */
    private String prescriptionToTenMillion(int number) {

        if (number < 1000000) {
            return prescriptionToOneMillion(number);
        }

        if (number > 9999999) {
            return prescriptionToTwentyMillions(number);
        }

        if (number % 1000000 == 0) {
            if (number / 1000000  == 1) {
                return digits[number / 1000000 - 1].substring(0, 1).toUpperCase()
                        + digits[number / 1000000 - 1].substring(1) + millionCases[0];
            } else if (number / 1000000 >= 2 && number / 1000000 < 5) {
                return digits[number / 1000000 - 1].substring(0, 1).toUpperCase()
                        + digits[number / 1000000 - 1].substring(1) + millionCases[1];
            } else if (number / 1000000 >= 5){
                return digits[number / 1000000 - 1].substring(0, 1).toUpperCase()
                        + digits[number / 1000000 - 1].substring(1) + millionCases[2];
            }
        }

        if (number / 1000000  == 1 && number % 1000000 != 0) {
                return digits[number / 1000000 - 1].substring(0, 1).toUpperCase()
                        + digits[number / 1000000 - 1].substring(1) + millionCases[0]
                        + prescriptionToOneMillion(number - 1000000 * (number / 1000000)).toLowerCase();
            } else if (number / 1000000 >= 2 && number / 1000000 < 5) {
                return digits[number / 1000000 - 1].substring(0, 1).toUpperCase()
                        + digits[number / 1000000 - 1].substring(1) + millionCases[1]
                        + prescriptionToOneMillion(number - 1000000 * (number / 1000000)).toLowerCase();
            } else {
                return digits[number / 1000000 - 1].substring(0, 1).toUpperCase()
                        + digits[number / 1000000 - 1].substring(1) + millionCases[2]
                        + prescriptionToOneMillion(number - 1000000 * (number / 1000000)).toLowerCase();
            }
    }

    /**
     * Метод преобразозывает в пропись числа от 1000000 до 19999999 включительно
     * Внимание: метод всегда возвращает пропись, начиная с заглавной буквы
     * @param number - число для преобразования
     * @return String - сумма прописью
     */
    private String prescriptionToTwentyMillions(int number) {

        if (number < 10000000) {
            return prescriptionToTenMillion(number);
        }

        if (number > 19999999) {
            return prescriptionToHundredMillions(number);
        }

        if (number % 1000000 == 0) {
            return secondDozen[number / 1000000 - 10].substring(0, 1).toUpperCase()
                    + secondDozen[number / 1000000 - 10].substring(1) + millionCases[2];
        } else {
            return secondDozen[number / 1000000 - 10].substring(0, 1).toUpperCase()
                    + secondDozen[number / 1000000 - 10].substring(1) + millionCases[2]
                    + prescriptionToOneMillion(number - 1000000 * (number / 1000000)).toLowerCase();
        }
    }

    /**
     * Метод преобразозывает в пропись числа от 2000000 до 99999999 включительно
     * Внимание: метод всегда возвращает пропись, начиная с заглавной буквы
     * @param number - число для преобразования
     * @return String - сумма прописью
     */
    private String prescriptionToHundredMillions(int number) {

        if (number < 20000000) {
            return prescriptionToTwentyMillions(number);
        }

        if (number > 99999999) {
            return prescriptionToOneBillion(number);
        }

        if (number % 10000000 == 0) {
            return dozens[number / 10000000 - 1].substring(0, 1).toUpperCase()
                    + dozens[number / 10000000 - 1].substring(1) + millionCases[2];
        } else if (number % 1000000 == 0) {
            return dozens[number / 10000000 - 1].substring(0, 1).toUpperCase()
                    + dozens[number / 10000000 - 1].substring(1)
                    + prescriptionToTenMillion(number - 10000000 * (number / 10000000)).toLowerCase();
        }  else {
            return dozens[number / 10000000 - 1].substring(0, 1).toUpperCase()
                    + dozens[number / 10000000 - 1].substring(1)
                    + prescriptionToOneMillion(number - 10000000 * (number / 10000000)).toLowerCase();
        }
    }

    /**
     * Метод преобразозывает в пропись числа от 100000000 до 999999999 включительно
     * Внимание: метод всегда возвращает пропись, начиная с заглавной буквы
     * @param number - число для преобразования
     * @return String - сумма прописью
     */
    private String prescriptionToOneBillion(int number) {

        if (number < 100000000) {
            return prescriptionToHundredMillions(number);
        }

        if (number % 100000000 == 0) {
            return hundreds[number / 100000000 - 1].substring(0, 1).toUpperCase()
                    + hundreds[number / 100000000 - 1].substring(1) + millionCases[2];
        } else if (number % 10000000 == 0) {
            return hundreds[number / 100000000 - 1].substring(0, 1).toUpperCase()
                    + hundreds[number / 100000000 - 1].substring(1)
                    + prescriptionToHundredMillions( number % 100000000).toLowerCase();
        }
        return hundreds[number / 100000000 - 1].substring(0, 1).toUpperCase()
                + hundreds[number / 100000000 - 1].substring(1)
                + prescriptionToHundredMillions( number % 100000000).toLowerCase();
    }

    /**
     * Метод преобразозывает в пропись дробное число
     * Внимание: метод всегда возвращает пропись, начиная с заглавной буквы
     * @param number - число для преобразования
     * @return String - сумма прописью
     */
    public String toString(double number) {
        int wholePart;
        int fractionalPart;
        this.secondType = true;
        wholePart = (int) number; // целая часть числа
        fractionalPart = (int) (number * 100 % 100);

        if (wholePart % 10 == 1 && wholePart != 11) {
            if (fractionalPart % 10 == 1 && fractionalPart != 11) {
                return toString(wholePart) + "целая " + toString(Math.abs(fractionalPart)).toLowerCase() + "сотая ";
            } else {
                return toString(wholePart) + "целая " + toString(Math.abs(fractionalPart)).toLowerCase() + "сотых ";
            }
        } else if (fractionalPart % 10 == 1 && fractionalPart != 11) {
            return toString(wholePart) + "целых " + toString(Math.abs(fractionalPart)).toLowerCase() + "сотая ";
        } else {
            return toString(wholePart) + "целых " + toString(Math.abs(fractionalPart)).toLowerCase() + "сотых ";
        }
    }

    /**
     * Метод преобразозывает количество прошедших дней в недели
     * @param day - количество дней
     * @return String - количество прошедших недель
     */
    public String toWeek(int day) {
        int weeks = day / 7;

        if (weeks < 0) {
            return "Неверно введено количество дней";
        } else if ((weeks % 10 == 0) || (weeks % 10 >= 5) || (weeks >= 11 && weeks <= 19)) {
            return weeks + " недель";
        } else if (weeks % 10 >= 2 && weeks % 10 <= 4) {
            return weeks + " недели";
        } else if (weeks % 10 == 1){
            return weeks + " неделя";
        } else {
            return "Невозможно вычислить число недель";
        }
    }

    /**
     * Метод преобразозывает миллисекунды в часы, минуты, секунды, миллисекунды
     * @param millisecond - число миллисекунд
     * @param shortFormat - формат вывода
     * @return String - преобразованная строка
     */
    public String toHoursMinuteSecondMillisecond(long millisecond, boolean shortFormat) {
        String resultString = "";
        int hours = (int) millisecond / 3_600_000;
        int minutes = (int) ((millisecond - 3_600_000 * hours) / 60_000);
        int seconds = (int) ((millisecond - 3_600_000 * hours - 60_000 * minutes) / 1000);
        int milliseconds = (int) (millisecond - 3_600_000 * hours - 60_000 * minutes - 1000 * seconds);

        if (millisecond < 0) {
            return "Преобразование невозможно";
        }

        if (shortFormat) {
            return String.format("%02d", hours) + ":" + String.format("%02d", minutes) + ":"
                    + String.format("%02d", seconds) + "." + String.format("%03d", milliseconds);
        }

        if (((hours % 10 == 0) || (hours % 10 >= 5) || (hours >= 11 && hours <= 19))) {
            resultString = hours + " часов ";
        } else if (hours % 10 >= 2 && hours % 10 <= 4) {
            resultString = hours + " часа ";
        } else if (hours % 10 == 1) {
            resultString = hours + " час ";
        }

        if (((minutes % 10 == 0) || (minutes % 10 >= 5) || (minutes >= 11 && minutes <= 19))) {
            resultString = resultString + minutes + " минут ";
        } else if (minutes % 10 >= 2 && minutes % 10 <= 4) {
            resultString = resultString + minutes + " минуты ";
        } else if (minutes % 10 == 1) {
            resultString = resultString + minutes + " минута ";
        }

        if (((seconds % 10 == 0) || (seconds % 10 >= 5) || (seconds >= 11 && seconds <= 19))) {
            resultString = resultString + seconds + " секунд ";
        } else if (seconds % 10 >= 2 && seconds % 10 <= 4) {
            resultString = resultString + seconds + " секунды ";
        } else if (seconds % 10 == 1) {
            resultString = resultString + seconds + " секунда ";
        }

        if (((milliseconds % 10 == 0) || (milliseconds % 10 >= 5) || (milliseconds >= 11 && milliseconds <= 19))) {
            resultString = resultString + milliseconds + " миллисекунд ";
        } else if (milliseconds % 10 >= 2 && milliseconds % 10 <= 4) {
            resultString = resultString + milliseconds + " миллисекунды ";
        } else if (milliseconds % 10 == 1) {
            resultString = resultString + milliseconds + " миллисекунда ";
        }

        return resultString;
    }
}