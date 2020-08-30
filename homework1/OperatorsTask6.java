package homeworks.homework1;

public class OperatorsTask6 {
    public static void main(String[] args) {
        int[] array = {0, 3, 2, 1, 1, 8, 0, 9, 9, 5};

        String result = createPhoneNumber(array);
        System.out.println(result);
    }

    static String createPhoneNumber(int[] numbers) { ;
        return "(" + numbers[0] + numbers[1] + numbers[2] + ") " + numbers[3] + numbers[4] + numbers[5] + "-" + numbers[6] + numbers[7] + numbers[8] + numbers[9];
    }
}