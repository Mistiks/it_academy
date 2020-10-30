package homeworks.homework9.runner;

import homeworks.homework9.entity.Student;
import homeworks.homework9.utils.service.fileservice.FileWorker;
import homeworks.homework9.utils.service.comparator.StudentComparator;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HomeworkMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Выберите режим работы программы (1 - бинарный, 2 - текстовый):");
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                choice = 0;
                scanner.nextLine();
            }
        } while (choice != 1 && choice != 2);

        switch (choice) {
            case 1:
                workAsBin();
                break;
            case 2:
                workAsTxt();
                break;
        }
    }

    public static void workAsBin() {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList;
        FileWorker fileWorker = new FileWorker();
        StudentComparator comparator = new StudentComparator();
        ArrayList<Student> readStudent = new ArrayList<>();
        ArrayList<Student> topStudent = new ArrayList<>();
        int amount;

        System.out.println("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        if (filePath.trim().length() == 0) { // пустой ввод
            filePath = "students.bin";
        }

        File file = new File(filePath);

        if (!file.exists()) {
            studentList = Stream.generate(Student::createStudent).limit(10000).collect(Collectors.toList());
            fileWorker.createBinFile(file, studentList);
        }

        readStudent = fileWorker.readBinFile(file);
        readStudent.sort(comparator);

        System.out.println("Введите число студентов, которое нужно вывести: ");
        amount = scanner.nextInt();

        for (int i = 0; i < amount; i++) {
            Student listStudent = readStudent.get(i);
            System.out.println(listStudent.toString());
            topStudent.add(listStudent);
        }

        filePath = file.getParent();
        if (filePath == null) {
            filePath = "top.bin";
        } else {
            filePath = filePath.concat("\\top.bin");
        }

        file = new File(filePath);
        fileWorker.createBinFile(file, topStudent);
    }

    public static void workAsTxt() {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList;
        FileWorker fileWorker = new FileWorker();
        StudentComparator comparator = new StudentComparator();
        ArrayList<Student> readStudent = new ArrayList<>();
        ArrayList<Student> topStudent = new ArrayList<>();
        int amount;

        System.out.println("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        if (filePath.trim().length() == 0) { // пустой ввод
            filePath = "students.txt";
        }

        File file = new File(filePath);

        if (!file.exists()) {
            studentList = Stream.generate(Student::createStudent).limit(10000).collect(Collectors.toList());
            fileWorker.createTxtFile(file, studentList);
        }

        readStudent = fileWorker.readTxtFile(file);
        readStudent.sort(comparator);

        System.out.println("Введите число студентов, которое нужно вывести: ");
        amount = scanner.nextInt();

        for (int i = 0; i < amount; i++) {
            Student listStudent = readStudent.get(i);
            System.out.println(listStudent.toString());
            topStudent.add(listStudent);
        }

        filePath = file.getParent();
        if (filePath == null) {
            filePath = "top.txt";
        } else {
            filePath = filePath.concat("\\top.txt");
        }

        file = new File(filePath);
        fileWorker.createTxtFile(file, topStudent);
    }
}