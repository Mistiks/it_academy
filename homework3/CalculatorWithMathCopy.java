package homeworks.homework3;

public class CalculatorWithMathCopy implements Calculations {

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
        return Math.pow(number, exponent);
    }

    public double module(double number) {
        return Math.abs(number);
    }

    public double sqrt(double number) {
        return Math.sqrt(number);
    }
}
