package homeworks.homework3;

public class CalculatorWithMemoryMain {
    public static void main(String[] args) {
        CalculatorWithMathCopy calc = new CalculatorWithMathCopy();
        Calculations calculations = calc;
        CalculatorWithMemory calculator = new CalculatorWithMemory(calc);
        double answer = 0d;

        calculator.division(28,5);
        calculator.writeMemory();
        calculator.exponentiation(calculator.readMemory(), 2);
        calculator.writeMemory();
        calculator.sum(calculator.readMemory(), 4.1);
        calculator.writeMemory();
        calculator.multiplication(15,7);
        answer = calculator.sum(calculator.getResult(), calculator.readMemory());
        System.out.printf("Значение выражения равно " + "%.3f%n", answer);
    }
}
