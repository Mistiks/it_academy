package homeworks.homework2;

public class CyclesTask4 {
    public static void main(String[] args) {
        long a = 1L;
        long beforeOverflow = 0L;
        long afterOverflow = 0L;

        for(;;) {
            beforeOverflow = a;
            a *= 3;
            afterOverflow = a;
            if (afterOverflow < beforeOverflow) {
                System.out.println("Число до переполнения = " + beforeOverflow);
                System.out.println("Число после переполнения = " + afterOverflow);
                break;
            }
        }

        a = 1L;

        for(;;) {
            beforeOverflow = a;
            a *= 3;
            afterOverflow = a;
            if (Long.MAX_VALUE / 3 < afterOverflow) {
                System.out.println("Число до переполнения, высчитанное вторым способом = " + beforeOverflow * 3);
                System.out.println("Число после переполнения, высчитанное вторым способом = " + afterOverflow * 3);
                break;
            }
        }
    }
}
