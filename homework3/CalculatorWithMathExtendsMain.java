package homeworks.homework3;

public class CalculatorWithMathExtendsMain {
    public static void main(String[] args) {
        double result = 0d;

        CalculatorWithMathExtends calculator = new CalculatorWithMathExtends();
        result = calculator.sum(calculator.sum(4.1, calculator.multiplication(15, 7)),
                calculator.exponentiation(calculator.division(28, 5), 2));
        System.out.printf("Результат вычисления классом CalculatorWithMathExtends: " + "%.3f%n", result);
        System.out.println("Деление на 0 классом CalculatorWithMathExtends: " + calculator.division(result, 0));
        System.out.println("Деление на 0.0d классом CalculatorWithMathExtends: " + calculator.division(result, 0.0d));
    }

}
