package homeworks.homework6.service.comparator;

import homeworks.homework6.entity.Animal;

import java.util.Comparator;

public class AnimalComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal animal1, Animal animal2) {
        int result = animal1.getAge() - animal2.getAge();

        if (result != 0) {
            return result;
        }

        return animal1.getNick().compareTo(animal2.getNick());
    }
}