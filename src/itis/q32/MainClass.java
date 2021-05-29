package itis.q32;

/*
В папке resources находятся два .csv файла.
Один содержит данные о группах в университете в следующем формате: ID группы, название группы, код группы
Второй содержит данные о студентах: ФИО, дата рождения, айди группы, количество очков рейтинга

напишите код который превратит содержимое файлов в обьекты из пакета "entities", выведите в консоль всех студентов,
в читабельном виде, с информацией о группе
Используя StudentService, выведите:

1. Число групп с только совершеннолетними студентами
2. Самую маленькую группу
3. Отношение группа - сумма балов студентов фамилия которых совпадает с заданной строкой
4. Отношения студент - дельта баллов до проходного порога (порог передается параметром),
сгруппированные по признаку пройден порог, или нет

Требования к реализации: все методы в StudentService должны быть реализованы с использованием StreamApi.
Использование обычных циклов и дополнительных переменных приведет к снижению баллов, но допустимо.
Парсинг файлов и реализация методов оцениваются ОТДЕЛЬНО
*/

import itis.q32.entities.Group;
import itis.q32.entities.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class MainClass {

    private StudentService studentService = new StudentServiceImpl();

    public static void main(String[] args) {
        new MainClass().run(
                "C:\\prgmm\\src\\q32-students\\src\\itis\\q32\\resources\\students.csv",
                "C:\\prgmm\\src\\q32-students\\src\\itis\\q32\\resources\\groups.csv");
    }

    private void run(String studentsPath, String groupsPath) {
        try {
            ArrayList<Student> students = new ArrayList<>();
            HashMap<String, Group> groups = new HashMap<>();
            BufferedReader br = new BufferedReader(new FileReader(groupsPath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                groups.put(arr[0],
                        new Group(arr[1].trim(), Long.parseLong(arr[0].trim()), arr[2].trim()));
            }

            br = new BufferedReader(new FileReader(studentsPath));
            while((line = br.readLine())!=null){
                String[] arr = line.split(",");
                students.add(
                        new Student(arr[0].trim(),groups.get(arr[2].trim()),Integer.parseInt(arr[3].trim()), LocalDate.parse(arr[1].trim())));
            }

// tests
// count
            System.out.println(studentService.countGroupsWithOnlyAdultStudents(students));
// surname
            System.out.println(studentService.getGroupScoreSumMap(students,"Смит"));
            System.out.println(studentService.getSmallestGroup(students));
            System.out.println(studentService.groupStudentScoreWithThreshold(students,50));
        } catch (IOException e) {

        }
    }

}