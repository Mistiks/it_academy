package homeworks.homework3;

public class CalculatorWithMathExtends extends CalculatorWithOperator implements Calculations {

    @Override
    public double exponentiation(double number, int exponent) {
        return Math.pow(number, exponent);
    }

    @Override
    public double module(double number) {
        return Math.abs(number);
    }

    @Override
    public double sqrt(double number) {
        return Math.sqrt(number);
    }
}
