package homeworks.homework9.runner;

import homeworks.homework9.entity.Student;
import homeworks.homework9.utils.service.fileservice.FileWorker;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadTopMain {
    public static void main(String[] args) {
        File file;
        FileWorker fileWorker = new FileWorker();
        ArrayList<Student> topStudent;
        Scanner scanner = new Scanner(System.in);
        String filePath;
        int choice;
        int amount = 0;

        do {
            System.out.println("Выберите файл для чтения (1 - бинарный, 2 - текстовый):");
            try {
                choice = scanner.nextInt();
                System.out.println("Введите количество студентов для вывода");
                amount = scanner.nextInt();
            } catch (InputMismatchException e) {
                choice = 0;
                scanner.nextLine();
            }
        } while (choice != 1 && choice != 2);

        switch (choice) {
            case 1:
                scanner = new Scanner(System.in);
                System.out.println("Введите путь к файлу: ");
                filePath = scanner.nextLine();
                file = new File(filePath);

                if (!file.exists()) {
                    System.out.println("Файла не существует");
                    break;
                }

                topStudent = fileWorker.readBinFile(file);

                if (topStudent.size() < amount) {
                    amount = topStudent.size();
                }

                for (int i = topStudent.size() - 1; i > topStudent.size() - amount - 1; i--) {
                    System.out.println(topStudent.get(i).toString());
                }

                break;
            case 2:
                scanner = new Scanner(System.in);
                System.out.println("Введите путь к файлу: ");
                filePath = scanner.nextLine();
                file = new File(filePath);

                if (!file.exists()) {
                    System.out.println("Файла не существует");
                    break;
                }

                topStudent = fileWorker.readTxtFile(file);

                if (topStudent.size() < amount) {
                    amount = topStudent.size();
                }

                for (int i = topStudent.size() - 1; i > topStudent.size() - amount - 1; i--) {
                    System.out.println(topStudent.get(i).toString());
                }

                break;
        }
    }
}