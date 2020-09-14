package homeworks.homework3;

public class CalculatorWithOperator implements Calculations {
    
    public double sum(double firstTerm, double secondTerm) {
        return firstTerm + secondTerm;
    }

    public double subtraction(double minuend, double subtrahend) {
        return minuend - subtrahend;
    }

    public double multiplication(double firstMultiplier, double secondMultiplier) {
        return firstMultiplier * secondMultiplier;
    }

    public double division(double dividend, double divider) {
        return dividend / divider;
    }

    public double exponentiation(double number, int exponent) {
        double result = 1d;

        for (int i = 0; i < exponent ; i++) {
            result *= number;
        }

        return result;
    }

    public double module(double number) {
        if(number < 0) {
            return -1 * number;
        }

        return number;
    }

    public double sqrt(double number) {
        if (number == 0) {
            return 0;
        }

        if (number < 0) {
            return -1; // ошибка получения корня из отрицательного числа
        }

        double precision = 0.0001d; // точность (или разница между предыдущим и следующим вычисленным значениями)
        double root = number / 2; // начальное приближение
        double temp;

        do {
            temp = root;
            root = (temp + (number / temp)) / 2; // применение метода Ньютона для функции корня
        } while (module(temp - root) > precision);

        return root;
    }
}
