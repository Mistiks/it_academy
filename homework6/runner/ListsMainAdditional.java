package homeworks.homework6.runner;

import homeworks.homework6.entity.Animal;
import homeworks.homework6.service.comparator.AnimalComparator;
import homeworks.homework6.utils.PersonAndAnimalOperator;
import homeworks.homework6.utils.TimeStorage;

import java.util.*;

// Класс для реализации дополнительных заданий домашней работы
public class ListsMainAdditional {
    public static void main(String[] args) {
        PersonAndAnimalOperator operator = new PersonAndAnimalOperator();
        AnimalComparator animalComparator = new AnimalComparator();
        TimeStorage storage = new TimeStorage();
        List<Animal> linkedAnimal = new LinkedList<>();
        List<Animal> arrayAnimal = new ArrayList<>();
        Set<Animal> hashAnimal = new HashSet<>();
        Set<Animal> treeAnimal = new TreeSet<>(animalComparator);
        long startTimer;
        long endTimer;

        startTimer = System.currentTimeMillis();
        Collections.addAll(linkedAnimal, operator.createAnimals(10000));
        endTimer = System.currentTimeMillis();
        storage.setAddLinkedList(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        Collections.addAll(arrayAnimal, operator.createAnimals(10000));
        endTimer = System.currentTimeMillis();
        storage.setAddArrayList(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        Collections.addAll(hashAnimal, operator.createAnimals(10000));
        endTimer = System.currentTimeMillis();
        storage.setAddHashSet(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        Collections.addAll(treeAnimal, operator.createAnimals(10000));
        endTimer = System.currentTimeMillis();
        storage.setAddTreeSet(endTimer - startTimer);

        System.out.println("Операция: заполнение LinkedList. Заняла " +  storage.getAddLinkedList() + " мс");
        System.out.println("Операция: заполнение ArrayList. Заняла " + storage.getAddArrayList() + " мс");
        System.out.println("Операция: заполнение HashSet. Заняла " + storage.getAddHashSet() + " мс");
        System.out.println("Операция: заполнение TreeSet. Заняла " + storage.getAddTreeSet() + " мс");

        System.out.println();
        operator.animalListOperations(linkedAnimal, animalComparator);
        System.out.println();
        operator.animalListOperations(arrayAnimal, animalComparator);
        System.out.println();
        operator.animalListOperations(hashAnimal, animalComparator);
        System.out.println();
        operator.animalListOperations(treeAnimal, animalComparator);
    }
}