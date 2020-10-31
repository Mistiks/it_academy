package homeworks.homework9.utils.service.creator;

import java.util.Random;

public class FieldCreator {
    private static final char[] upperCaseLetters = ("QWERTYUIOPASDFGHJKLZXCVBNM").toCharArray();
    private static final char[] lowerCaseLetters = ("qwertyuiopasdfghjklzxcvbnm").toCharArray();
    private static final Random random = new Random();

    public static String createName() {
        int nameLength = random.nextInt(10) + 3; // длина от 3 до 12 символов
        StringBuilder nameBuilder = new StringBuilder();

        nameBuilder.append(upperCaseLetters[random.nextInt(upperCaseLetters.length)]);

        for (int j = 0; j < nameLength - 1; j++) {
            nameBuilder.append(lowerCaseLetters[random.nextInt(lowerCaseLetters.length)]);
        }

        return nameBuilder.toString();
    }

    public static String createSurname() {
        int surnameLength = random.nextInt(10) + 3;
        StringBuilder surnameBuilder = new StringBuilder();

        surnameBuilder.append(upperCaseLetters[random.nextInt(upperCaseLetters.length)]);

        for (int j = 0; j < surnameLength - 1; j++) {
            surnameBuilder.append(lowerCaseLetters[random.nextInt(lowerCaseLetters.length)]);
        }

        return surnameBuilder.toString();
    }

    public static String createPatronymic() {
        int patronymicLength = random.nextInt(10) + 3;
        StringBuilder patronymicBuilder = new StringBuilder();

        patronymicBuilder.append(upperCaseLetters[random.nextInt(upperCaseLetters.length)]);

        for (int j = 0; j < patronymicLength - 1; j++) {
            patronymicBuilder.append(lowerCaseLetters[random.nextInt(lowerCaseLetters.length)]);
        }

        return patronymicBuilder.toString();
    }

    public static int createMark() {
        return random.nextInt(10) + 1;
    }
}