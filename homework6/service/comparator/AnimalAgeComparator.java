package homeworks.homework6.service.comparator;

import homeworks.homework6.entity.Animal;

import java.util.Comparator;

public class AnimalAgeComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal animal1, Animal animal2) {
        return animal1.getAge() - animal2.getAge();
    }
}