package homeworks.homework6;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        int result = person1.getPassword().length() - person2.getPassword().length();

        if (result != 0) {
            return result;
        }

        return person1.getNick().compareTo(person2.getNick());
    }
}