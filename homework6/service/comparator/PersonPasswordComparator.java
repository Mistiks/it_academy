package homeworks.homework6.service.comparator;

import homeworks.homework6.entity.Person;

import java.util.Comparator;

public class PersonPasswordComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        return person1.getPassword().length() - person2.getPassword().length();
    }
}