package homeworks.homework6;

import java.util.*;

// Класс для реализации дополнительных заданий домашней работы
public class ListsMainAdditional {
    public static void main(String[] args) {
        PersonAndAnimalOperator operator = new PersonAndAnimalOperator();
        AnimalComparator animalComparator = new AnimalComparator();
        List<Animal> linkedAnimal = new LinkedList<>();
        List<Animal> arrayAnimal = new ArrayList<>();
        Set<Animal> hashAnimal = new HashSet<>();
        Set<Animal> treeAnimal = new TreeSet<>(animalComparator);
        long startTimer;
        long endTimer;
        List<Long> timeResults = new ArrayList<>();

        startTimer = System.currentTimeMillis();
        Collections.addAll(linkedAnimal, operator.createAnimals(10000));
        endTimer = System.currentTimeMillis();
        timeResults.add(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        Collections.addAll(arrayAnimal, operator.createAnimals(10000));
        endTimer = System.currentTimeMillis();
        timeResults.add(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        Collections.addAll(hashAnimal, operator.createAnimals(10000));
        endTimer = System.currentTimeMillis();
        timeResults.add(endTimer - startTimer);

        startTimer = System.currentTimeMillis();
        Collections.addAll(treeAnimal, operator.createAnimals(10000));
        endTimer = System.currentTimeMillis();
        timeResults.add(endTimer - startTimer);

        System.out.println("Операция: заполнение LinkedList. Заняла " + timeResults.get(0) + " мс");
        System.out.println("Операция: заполнение ArrayList. Заняла " + timeResults.get(1) + " мс");
        System.out.println("Операция: заполнение HashSet. Заняла " + timeResults.get(2) + " мс");
        System.out.println("Операция: заполнение TreeSet. Заняла " + timeResults.get(3) + " мс");

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