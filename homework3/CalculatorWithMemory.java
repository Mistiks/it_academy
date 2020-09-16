package homeworks.homework3;

public class CalculatorWithMemory implements Calculations {
    private Calculations calculations;
    private double memory = 0d;
    private double result = 0d;

    public CalculatorWithMemory(Calculations calculator) {
        this.calculations = calculator;
    }

    public double sum(double firstTerm, double secondTerm) {
        this.result = calculations.sum(firstTerm, secondTerm);
        return this.result;
    }

    public double subtraction(double minuend, double subtrahend) {
        this.result = calculations.subtraction(minuend, subtrahend);
        return this.result;
    }

    public double multiplication(double firstMultiplier, double secondMultiplier) {
        this.result = calculations.multiplication(firstMultiplier, secondMultiplier);
        return this.result;
    }

    public double division(double dividend, double divider) {
        this.result = calculations.division(dividend, divider);
        return this.result;
    }

    public double exponentiation(double number, int exponent) {
        this.result = calculations.exponentiation(number, exponent);
        return this.result;
    }

    public double module(double number) {
        this.result = calculations.module(number);
        return this.result;
    }

    public double sqrt(double number) {
        this.result = calculations.sqrt(number);
        return this.result;
    }

    public void writeMemory() {
        this.memory = this.result;
    }

    public double readMemory() {
        double valueOfMemory = this.memory;
        this.memory = 0d;
        return valueOfMemory;
    }

    public double getResult() {
        return this.result;
    }
}
