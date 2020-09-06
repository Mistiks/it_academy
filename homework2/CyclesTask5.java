package homeworks.homework2;

public class CyclesTask5 {
    public static void main(String[] args) {

        for (int i = 1; i <= 10 ; i++) {
            for (int j = 2; j <= 5 ; j++) {
                System.out.printf("%d * %d = %d\t", j, i, j * i);
                if (j == 5) {
                    System.out.println();
                }
            }
        }

        System.out.println();

        for (int i = 1; i <= 10 ; i++) {
            for (int j = 6; j <= 9 ; j++) {
                System.out.printf("%d * %d = %d\t", j, i, j * i);
                if (j == 9) {
                    System.out.println();
                }
            }
        }
    }
}