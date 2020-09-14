package homeworks.homework3;

public class CalculatorWithOperatorMain {
    public static void main(String[] args) {
        CalculatorWithOperator calculator = new CalculatorWithOperator();
        double result = 0d;

        result = calculator.sum(calculator.sum(4.1, calculator.multiplication(15, 7)),
                calculator.exponentiation(calculator.division(28, 5), 2));
        System.out.printf("Результат вычисления классом CalculatorWithOperator: " + "%.3f%n", result);
        System.out.println("Деление на 0 классом CalculatorWithOperator: " + calculator.division(result, 0));
        System.out.println("Деление на 0.0d классом CalculatorWithOperator: " + calculator.division(result, 0.0d));
    }
}
