package homeworks.homework6;

import java.util.*;

public class ListsMain {

    public static void main(String[] args) {
        final char[] allLetters = ("qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789").toCharArray();
        Random random = new Random();
        PersonComparator personComparator = new PersonComparator();
        Person[] persons = new Person[4000000];
        List<Person> linkedPerson = new LinkedList<>();
        List<Person> arrayPerson = new ArrayList<>();
        Set<Person> hashPerson = new HashSet<>();
        Set<Person> treePerson = new TreeSet<>(personComparator);
        StringBuilder nickBuilder = new StringBuilder();
        StringBuilder passwordBuilder = new StringBuilder();
        int nickLength;
        int passwordLength;
        long startTimer;
        long endTimer;
        List<Long> timeResults = new ArrayList<>();

        for (int i = 0; i < 4000000; i++) {
            nickLength = random.nextInt(13) + 3; // длина ника от 3 до 15 символов
            passwordLength = random.nextInt(6) + 5; // длина пароля от 5 до 10 символов

            for (int j = 0; j < nickLength; j++) {
                nickBuilder.append(allLetters[random.nextInt(allLetters.length)]);
            }

            for (int k = 0; k < passwordLength; k++) {
                passwordBuilder.append(allLetters[random.nextInt(allLetters.length)]);
            }

            persons[i] = new Person(nickBuilder.toString(), passwordBuilder.toString());
            nickBuilder.setLength(0);
            passwordBuilder.setLength(0);
        }

        Person[] person1 = Arrays.copyOfRange(persons, 0, 999999);
        Person[] person2 = Arrays.copyOfRange(persons, 1000000, 1999999);
        Person[] person3 = Arrays.copyOfRange(persons, 2000000, 2999999);
        Person[] person4 = Arrays.copyOfRange(persons, 3000000, 3999999);

        startTimer = System.currentTimeMillis();
        Collections.addAll(linkedPerson, person1);
        endTimer = System.currentTimeMillis();
        timeResults.add(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        Collections.addAll(arrayPerson, person2);
        endTimer = System.currentTimeMillis();
        timeResults.add(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        Collections.addAll(hashPerson, person3);
        endTimer = System.currentTimeMillis();
        timeResults.add(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        Collections.addAll(treePerson, person4);
        endTimer = System.currentTimeMillis();
        timeResults.add(endTimer - startTimer);

        linkedPerson.sort(personComparator);
        arrayPerson.sort(personComparator);
        List<Person> hashPersonSorted = new ArrayList<>(hashPerson);
        hashPersonSorted.sort(personComparator);

        Iterator<Person> iterator1 = linkedPerson.iterator();
        startTimer = System.currentTimeMillis();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next().getInfo());
        }
        endTimer = System.currentTimeMillis();
        timeResults.add(endTimer - startTimer);

        Iterator<Person> iterator2 = arrayPerson.iterator();
        startTimer = System.currentTimeMillis();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next().getInfo());
        }
        endTimer = System.currentTimeMillis();
        timeResults.add(endTimer - startTimer);

        Iterator<Person> iterator3 = hashPerson.iterator();
        startTimer = System.currentTimeMillis();
        while (iterator3.hasNext()) {
            System.out.println(iterator3.next().getInfo());
        }
        endTimer = System.currentTimeMillis();
        timeResults.add(endTimer - startTimer);

        Iterator<Person> iterator4 = treePerson.iterator();
        startTimer = System.currentTimeMillis();
        while (iterator4.hasNext()) {
            System.out.println(iterator4.next().getInfo());
        }
        endTimer = System.currentTimeMillis();
        timeResults.add(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        for (int i = 0; i < linkedPerson.size(); i++) {
            System.out.println(linkedPerson.get(i).getInfo());
        }
        endTimer = System.currentTimeMillis();
        timeResults.add(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        for (int i = 0; i < arrayPerson.size(); i++) {
            System.out.println(arrayPerson.get(i).getInfo());
        }
        endTimer = System.currentTimeMillis();
        timeResults.add(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        List<Person> hashListPerson = new ArrayList<>(hashPerson);
        for (int i = 0; i < hashPerson.size(); i++) {
            System.out.println(hashListPerson.get(i).getInfo());
        }
        endTimer = System.currentTimeMillis();
        timeResults.add(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        List<Person> treeListPerson = new ArrayList<>(treePerson);
        for (int i = 0; i < treePerson.size(); i++) {
            System.out.println(treeListPerson.get(i).getInfo());
        }
        endTimer = System.currentTimeMillis();
        timeResults.add(endTimer - startTimer);

        Iterator<Person> iterator5 = linkedPerson.iterator();
        startTimer = System.currentTimeMillis();
        while (iterator5.hasNext()) {
            iterator5.next();
            iterator5.remove();
        }
        endTimer = System.currentTimeMillis();
        timeResults.add(endTimer - startTimer);

        Iterator<Person> iterator6 = arrayPerson.iterator();
        startTimer = System.currentTimeMillis();
        while (iterator6.hasNext()) {
            iterator6.next();
            iterator6.remove();
        }
        endTimer = System.currentTimeMillis();
        timeResults.add(endTimer - startTimer);

        Iterator<Person> iterator7 = hashPerson.iterator();
        startTimer = System.currentTimeMillis();
        while (iterator7.hasNext()) {
            iterator7.next();
            iterator7.remove();
        }
        endTimer = System.currentTimeMillis();
        timeResults.add(endTimer - startTimer);

        Iterator<Person> iterator8 = treePerson.iterator();
        startTimer = System.currentTimeMillis();
        while (iterator8.hasNext()) {
            iterator8.next();
            iterator8.remove();
        }
        endTimer = System.currentTimeMillis();
        timeResults.add(endTimer - startTimer);

        System.out.println("Операция: заполнение LinkedList. Заняла " + timeResults.get(0) + " мс");
        System.out.println("Операция: заполнение ArrayList. Заняла " + timeResults.get(1) + " мс");
        System.out.println("Операция: заполнение HashSet. Заняла " + timeResults.get(2) + " мс");
        System.out.println("Операция: заполнение TreeSet. Заняла " + timeResults.get(3) + " мс");
        System.out.println("Операция: итерирование LinkedList (iterator). Заняла " + timeResults.get(4) + " мс");
        System.out.println("Операция: итерирование ArrayList (iterator). Заняла " + timeResults.get(5) + " мс");
        System.out.println("Операция: итерирование HashSet (iterator). Заняла " + timeResults.get(6) + " мс");
        System.out.println("Операция: итерирование TreeSet (iterator). Заняла " + timeResults.get(7) + " мс");
        System.out.println("Операция: итерирование LinkedList (for). Заняла " + timeResults.get(8) + " мс");
        System.out.println("Операция: итерирование ArrayList (for). Заняла " + timeResults.get(9) + " мс");
        System.out.println("Операция: итерирование HashSet (for). Заняла " + timeResults.get(10) + " мс");
        System.out.println("Операция: итерирование TreeSet (for). Заняла " + timeResults.get(11) + " мс");
        System.out.println("Операция: удаление LinkedList (iterator). Заняла " + timeResults.get(12) + " мс");
        System.out.println("Операция: удаление ArrayList (iterator). Заняла " + timeResults.get(13) + " мс");
        System.out.println("Операция: удаление HashSet (iterator). Заняла " + timeResults.get(14) + " мс");
        System.out.println("Операция: удаление TreeSet (iterator). Заняла " + timeResults.get(15) + " мс");
    }
}