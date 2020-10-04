package homeworks.homework6;

import java.util.*;

public class PersonAndAnimalOperator {
    private final char[] allLetters = ("qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789").toCharArray();
    private final char[] upperCaseLetters = ("QWERTYUIOPASDFGHJKLZXCVBNM").toCharArray();
    private final char[] lowerCaseLetters = ("qwertyuiopasdfghjklzxcvbnm").toCharArray();
    private final Random random = new Random();

    public Person[] createPersons(int amount) {
        Person[] result = new Person[amount];
        StringBuilder nickBuilder = new StringBuilder();
        StringBuilder passwordBuilder = new StringBuilder();
        int nickLength;
        int passwordLength;

        for (int i = 0; i < amount; i++) {
            nickLength = random.nextInt(13) + 3; // длина ника от 3 до 15 символов
            passwordLength = random.nextInt(6) + 5; // длина пароля от 5 до 10 символов

            for (int j = 0; j < nickLength; j++) {
                nickBuilder.append(allLetters[random.nextInt(allLetters.length)]);
            }

            for (int k = 0; k < passwordLength; k++) {
                passwordBuilder.append(allLetters[random.nextInt(allLetters.length)]);
            }

            result[i] = new Person(nickBuilder.toString(), passwordBuilder.toString());
            nickBuilder.setLength(0);
            passwordBuilder.setLength(0);
        }

        return result;
    }

    public Animal[] createAnimals(int amount) {
        Animal[] result = new Animal[amount];
        StringBuilder nickBuilder = new StringBuilder();
        int nickLength;
        int age;

        for (int i = 0; i < amount; i++) {
            nickLength = random.nextInt(10) + 3; // длина клички от 3 до 12 символов
            age = random.nextInt(15) + 1; // возраст от 1 до 15
            nickBuilder.append(upperCaseLetters[random.nextInt(upperCaseLetters.length)]);

            for (int j = 0; j < nickLength - 1; j++) {
                nickBuilder.append(lowerCaseLetters[random.nextInt(lowerCaseLetters.length)]);
            }

            result[i] = new Animal(age, nickBuilder.toString());
            nickBuilder.setLength(0);
        }

        return result;
    }
}