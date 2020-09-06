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
    }
}
