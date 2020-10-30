package homeworks.homework9.entity;

import homeworks.homework9.utils.service.creator.FieldCreator;

import java.io.Serializable;

public class Student implements Serializable {
    String name;
    String surname;
    String patronymic;
    int mark;

    public Student(String name, String surname, String patronymic, int mark) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getMark() {
        return mark;
    }

    public String getFullName() {
        return getSurname().concat(" ").concat(getName()).concat(" ").concat(getPatronymic());
    }

    public static Student createStudent() {
        return new Student(FieldCreator.createName(), FieldCreator.createSurname(),
                FieldCreator.createPatronymic(), FieldCreator.createMark());
    }

    public String toString() {
        return "ФИО: " + getFullName() + "\tОценка: " + getMark();
    }
}