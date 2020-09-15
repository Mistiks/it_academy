package homeworks.homework3;

public class CalculatorWithCounter implements Calculations {
    private Calculations calculations;
    private int counter = 0;

    public CalculatorWithCounter(Calculations calculator) {
        this.calculations = calculator;
    }

    public double sum(double firstTerm, double secondTerm) {
        this.counter++;
        return calculations.sum(firstTerm, secondTerm);
    }

    public double subtraction(double minuend, double subtrahend) {
        this.counter++;
        return calculations.subtraction(minuend, subtrahend);
    }

    public double multiplication(double firstMultiplier, double secondMultiplier) {
        this.counter++;
        return calculations.multiplication(firstMultiplier, secondMultiplier);
    }

    public double division(double dividend, double divider) {
        this.counter++;
        return calculations.division(dividend, divider);
    }

    public double exponentiation(double number, int exponent) {
        this.counter++;
        return calculations.exponentiation(number, exponent);
    }

    public double module(double number) {
        this.counter++;
        return calculations.module(number);
    }

    public double sqrt(double number) {
        this.counter++;
        return calculations.sqrt(number);
    }

    public int getCountOperation() {
        return this.counter;
    }
}