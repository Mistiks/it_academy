package homeworks.homework9.utils.service.fileservice;

import homeworks.homework9.entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileWorker {

    public void createBinFile(File file, List list) {
        try {
            FileOutputStream writeData = new FileOutputStream(file);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(list);
            writeStream.flush();
            writeStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTxtFile(File file, List list) {
        Student student;

        try(FileWriter writer = new FileWriter(file, false)) {

            for (int i = 0; i < list.size() - 1; i++) {
                student = (Student) list.get(i);
                writer.write(student.getName() + "\n");
                writer.write(student.getSurname() + "\n");
                writer.write(student.getPatronymic() + "\n");
                writer.write(student.getMark() + "\n");
            }

            // последнего студента записываем отдельно, чтобы не было ненужного перехода на новую строку
            student = (Student) list.get(list.size() - 1);
            writer.write(student.getName() + "\n");
            writer.write(student.getSurname() + "\n");
            writer.write(student.getPatronymic() + "\n");
            writer.write("" + student.getMark());

            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Student> readBinFile(File file) {
        ArrayList<Student> students = null;
        try {
            FileInputStream readData = new FileInputStream(file);
            ObjectInputStream readStream = new ObjectInputStream(readData);

            students = (ArrayList<Student>) readStream.readObject();
            readStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return students;
    }

    public ArrayList<Student> readTxtFile(File file) {
        ArrayList<Student> students = new ArrayList<>();
        String name;
        String surname;
        String patronymic;
        int mark;

        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader reader = new BufferedReader(fileReader);
            name = reader.readLine();

            while (name != null) {
                surname = reader.readLine();
                patronymic = reader.readLine();
                mark = Integer.parseInt(reader.readLine());
                Student student = new Student(name, surname, patronymic, mark);
                students.add(student);
                name = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return students;
    }
}