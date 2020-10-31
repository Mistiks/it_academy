package homeworks.homework9.utils.service.comparator;

import homeworks.homework9.entity.Student;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        int result = student2.getMark() - student1.getMark();

        if (result != 0) {
            return result;
        } else {
            return student1.getName().compareTo(student2.getName());
        }
    }
}