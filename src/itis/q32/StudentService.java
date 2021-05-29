package itis.q32;

import itis.q32.entities.Group;
import itis.q32.entities.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    //Возвращает группу с наименьшим числом студентов
    Group getSmallestGroup(List<Student> students);

    //Считает число совершеннолетних студентов
    Integer countGroupsWithOnlyAdultStudents(List<Student> students);

    //Возвращает мапу где ключ - название группы, а значение - сумма рейтинга студентов с фамилией в параметре
    Map<String, Integer> getGroupScoreSumMap(List<Student> students, String studentSurname);

    //Возвращает мапу где ключ - пройден порог или нет, а значение - отношение где ключ фио студента,
    // а значение - дельта баллов до порога
    Map<Boolean, Map<String, Integer>> groupStudentScoreWithThreshold(List<Student> students, Integer threshold);


}
