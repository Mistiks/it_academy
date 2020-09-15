package homeworks.homework3;

public class CalculatorWithCounterMain {
    public static void main(String[] args) {
        CalculatorWithOperator calc = new CalculatorWithOperator();
        Calculations calculations = calc;
        CalculatorWithCounter calculator = new CalculatorWithCounter(calc);
        double result = 0d;

        result = calculator.sum(calculator.sum(4.1, calculator.multiplication(15, 7)),
                calculator.exponentiation(calculator.division(28, 5), 2));
        System.out.printf("Результат вычисления классом CalculatorWithCounter: " + "%.3f%n", result);
        System.out.println("Деление на 0 классом CalculatorWithCounter: " + calculator.division(result, 0));
        System.out.println("Деление на 0.0d классом CalculatorWithCounter: " + calculator.division(result, 0.0d));
        System.out.println("Количество проведенных операций: " + calculator.getCountOperation());
    }
}
