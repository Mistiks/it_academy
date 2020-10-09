package homeworks.homework1;

public class OperatorsTask6 {
    public static void main(String[] args) {
        int[] array = {0, 3, 2, 1, 1, 8, 0, 9, 9, 5};

        String result = createPhoneNumber(array);
        System.out.println(result);
    }

    static String createPhoneNumber(int[] numbers) { ;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) {
                builder.append("(");
                builder.append(numbers[i]);
            } else if (i == 2) {
                builder.append(numbers[i]);
                builder.append(") ");
            } else if (i == 5) {
                builder.append(numbers[i]);
                builder.append("-");
            } else {
                builder.append(numbers[i]);
            }
        }

        return builder.toString();
    }
}