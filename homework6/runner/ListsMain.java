package homeworks.homework6.runner;

import homeworks.homework6.entity.Person;
import homeworks.homework6.utils.PersonAndAnimalOperator;
import homeworks.homework6.service.comparator.PersonComparator;
import homeworks.homework6.utils.TimeStorage;

import java.util.*;

public class ListsMain {

    public static void main(String[] args) {
        PersonAndAnimalOperator operator = new PersonAndAnimalOperator();
        PersonComparator personComparator = new PersonComparator();
        TimeStorage storage = new TimeStorage();
        List<Person> linkedPerson = new LinkedList<>();
        List<Person> arrayPerson = new ArrayList<>();
        Set<Person> hashPerson = new HashSet<>();
        Set<Person> treePerson = new TreeSet<>(personComparator);
        long startTimer;
        long endTimer;

        startTimer = System.currentTimeMillis();
        Collections.addAll(linkedPerson, operator.createPersons(1000000));
        endTimer = System.currentTimeMillis();
        storage.setAddLinkedList(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        Collections.addAll(arrayPerson, operator.createPersons(1000000));
        endTimer = System.currentTimeMillis();
        storage.setAddArrayList(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        Collections.addAll(hashPerson, operator.createPersons(1000000));
        endTimer = System.currentTimeMillis();
        storage.setAddHashSet(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        Collections.addAll(treePerson, operator.createPersons(1000000));
        endTimer = System.currentTimeMillis();
        storage.setAddTreeSet(endTimer - startTimer);

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
        storage.setIteratorLinkedList(endTimer - startTimer);

        Iterator<Person> iterator2 = arrayPerson.iterator();
        startTimer = System.currentTimeMillis();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next().getInfo());
        }
        endTimer = System.currentTimeMillis();
        storage.setIteratorArrayList(endTimer - startTimer);

        Iterator<Person> iterator3 = hashPerson.iterator();
        startTimer = System.currentTimeMillis();
        while (iterator3.hasNext()) {
            System.out.println(iterator3.next().getInfo());
        }
        endTimer = System.currentTimeMillis();
        storage.setIteratorHashSet(endTimer - startTimer);

        Iterator<Person> iterator4 = treePerson.iterator();
        startTimer = System.currentTimeMillis();
        while (iterator4.hasNext()) {
            System.out.println(iterator4.next().getInfo());
        }
        endTimer = System.currentTimeMillis();
        storage.setIteratorTreeSet(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        for (int i = 0; i < linkedPerson.size(); i++) {
            System.out.println(linkedPerson.get(i).getInfo());
        }
        endTimer = System.currentTimeMillis();
        storage.setIteratorForLinkedList(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        for (int i = 0; i < arrayPerson.size(); i++) {
            System.out.println(arrayPerson.get(i).getInfo());
        }
        endTimer = System.currentTimeMillis();
        storage.setIteratorForArrayList(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        List<Person> hashListPerson = new ArrayList<>(hashPerson);
        for (int i = 0; i < hashPerson.size(); i++) {
            System.out.println(hashListPerson.get(i).getInfo());
        }
        endTimer = System.currentTimeMillis();
        storage.setIteratorForHashSet(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        List<Person> treeListPerson = new ArrayList<>(treePerson);
        for (int i = 0; i < treePerson.size(); i++) {
            System.out.println(treeListPerson.get(i).getInfo());
        }
        endTimer = System.currentTimeMillis();
        storage.setIteratorForTreeSet(endTimer - startTimer);

        Iterator<Person> iterator5 = linkedPerson.iterator();
        startTimer = System.currentTimeMillis();
        while (iterator5.hasNext()) {
            iterator5.next();
            iterator5.remove();
        }
        endTimer = System.currentTimeMillis();
        storage.setIteratorDeleteLinkedList(endTimer - startTimer);

        Iterator<Person> iterator6 = arrayPerson.iterator();
        startTimer = System.currentTimeMillis();
        while (iterator6.hasNext()) {
            iterator6.next();
            iterator6.remove();
        }
        endTimer = System.currentTimeMillis();
        storage.setIteratorDeleteArrayList(endTimer - startTimer);

        Iterator<Person> iterator7 = hashPerson.iterator();
        startTimer = System.currentTimeMillis();
        while (iterator7.hasNext()) {
            iterator7.next();
            iterator7.remove();
        }
        endTimer = System.currentTimeMillis();
        storage.setIteratorDeleteHashSet(endTimer - startTimer);

        Iterator<Person> iterator8 = treePerson.iterator();
        startTimer = System.currentTimeMillis();
        while (iterator8.hasNext()) {
            iterator8.next();
            iterator8.remove();
        }
        endTimer = System.currentTimeMillis();
        storage.setIteratorDeleteTreeSet(endTimer - startTimer);

        System.out.println("Операция: заполнение LinkedList. Заняла " + storage.getAddLinkedList() + " мс");
        System.out.println("Операция: заполнение ArrayList. Заняла " + storage.getAddArrayList() + " мс");
        System.out.println("Операция: заполнение HashSet. Заняла " + storage.getAddHashSet() + " мс");
        System.out.println("Операция: заполнение TreeSet. Заняла " + storage.getAddTreeSet() + " мс");
        System.out.println("Операция: итерирование LinkedList (iterator). Заняла " + storage.getIteratorLinkedList() + " мс");
        System.out.println("Операция: итерирование ArrayList (iterator). Заняла " + storage.getIteratorArrayList() + " мс");
        System.out.println("Операция: итерирование HashSet (iterator). Заняла " + storage.getIteratorHashSet() + " мс");
        System.out.println("Операция: итерирование TreeSet (iterator). Заняла " + storage.getIteratorTreeSet() + " мс");
        System.out.println("Операция: итерирование LinkedList (for). Заняла " + storage.getIteratorForLinkedList() + " мс");
        System.out.println("Операция: итерирование ArrayList (for). Заняла " + storage.getIteratorForArrayList() + " мс");
        System.out.println("Операция: итерирование HashSet (for). Заняла " + storage.getIteratorForHashSet() + " мс");
        System.out.println("Операция: итерирование TreeSet (for). Заняла " + storage.getIteratorForTreeSet() + " мс");
        System.out.println("Операция: удаление LinkedList (iterator). Заняла " + storage.getIteratorDeleteLinkedList() + " мс");
        System.out.println("Операция: удаление ArrayList (iterator). Заняла " + storage.getIteratorDeleteArrayList() + " мс");
        System.out.println("Операция: удаление HashSet (iterator). Заняла " + storage.getIteratorDeleteHashSet() + " мс");
        System.out.println("Операция: удаление TreeSet (iterator). Заняла " + storage.getIteratorDeleteTreeSet() + " мс");
    }
}