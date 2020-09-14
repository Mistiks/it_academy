package homeworks.homework3;

public class CalculatorWithMathCopyMain {
    public static void main(String[] args) {
        double result = 0d;

        CalculatorWithMathCopy calculator = new CalculatorWithMathCopy();
        result = calculator.sum(calculator.sum(4.1, calculator.multiplication(15, 7)),
                calculator.exponentiation(calculator.division(28, 5), 2));
        System.out.printf("Результат вычисления классом CalculatorWithMathCopy: " + "%.3f%n", result);
        System.out.println("Деление на 0 классом CalculatorWithMathCopy: " + calculator.division(result, 0));
        System.out.println("Деление на 0.0d классом CalculatorWithMathCopy: " + calculator.division(result, 0.0d));
    }
}
