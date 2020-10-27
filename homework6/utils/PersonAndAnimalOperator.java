package homeworks.homework6.utils;

import homeworks.homework2.runner.sorting.SortTask1;
import homeworks.homework6.entity.Animal;
import homeworks.homework6.entity.Person;

import java.util.*;

public class PersonAndAnimalOperator {
    private final char[] allLetters = ("qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789").toCharArray();
    private final char[] upperCaseLetters = ("QWERTYUIOPASDFGHJKLZXCVBNM").toCharArray();
    private final char[] lowerCaseLetters = ("qwertyuiopasdfghjklzxcvbnm").toCharArray();
    private final Random random = new Random();
    TimeStorage storage = new TimeStorage();

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

    public void personListOperations (Collection list, Comparator<Person> comparator) {
        Person[] array = (Person[]) list.toArray(new Person[0]);
        long startTimer;
        long endTimer;

        SortTask1.bubbleSort(array, comparator);
        list.clear();
        Collections.addAll(list, array);

        Iterator<Person> iterator1 = list.iterator();
        startTimer = System.currentTimeMillis();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next().getInfo());
        }
        endTimer = System.currentTimeMillis();
        storage.setAddCollection(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getInfo());
        }
        endTimer = System.currentTimeMillis();
        storage.setIteratorForCollection(endTimer - startTimer);

        Iterator<Person> iterator2 = list.iterator();
        startTimer = System.currentTimeMillis();
        while (iterator2.hasNext()) {
            iterator2.next();
            iterator2.remove();
        }
        endTimer = System.currentTimeMillis();
        storage.setIteratorDeleteCollection(endTimer - startTimer);

        System.out.println("Операция: итерирование коллекции (iterator). Заняла " + storage.getAddCollection() + " мс");
        System.out.println("Операция: итерирование массива (for). Заняла " + storage.getIteratorForCollection() + " мс");
        System.out.println("Операция: удаление коллекции (iterator). Заняла " + storage.getIteratorDeleteCollection() + " мс");
    }

    public void animalListOperations (Collection list, Comparator<Animal> comparator) {
        Animal[] array = (Animal[]) list.toArray(new Animal[0]);
        long startTimer;
        long endTimer;

        SortTask1.bubbleSort(array, comparator);
        list.clear();
        Collections.addAll(list, array);

        Iterator<Animal> iterator1 = list.iterator();
        startTimer = System.currentTimeMillis();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next().getInfo());
        }
        endTimer = System.currentTimeMillis();
        storage.setAddCollection(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getInfo());
        }
        endTimer = System.currentTimeMillis();
        storage.setIteratorForCollection(endTimer - startTimer);

        Iterator<Animal> iterator2 = list.iterator();
        startTimer = System.currentTimeMillis();
        while (iterator2.hasNext()) {
            iterator2.next();
            iterator2.remove();
        }
        endTimer = System.currentTimeMillis();
        storage.setIteratorDeleteCollection(endTimer - startTimer);

        System.out.println("Операция: итерирование коллекции (iterator). Заняла " + storage.getAddCollection() + " мс");
        System.out.println("Операция: итерирование массива (for). Заняла " + storage.getIteratorForCollection() + " мс");
        System.out.println("Операция: удаление коллекции (iterator). Заняла " + storage.getIteratorDeleteCollection() + " мс");
    }
}