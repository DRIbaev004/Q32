package itis.q32;

import itis.q32.entities.Group;
import itis.q32.entities.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    @Override
    public Group getSmallestGroup(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(Student::getGroup, student -> new ArrayList<Student>(){{add(student);}},
                        (oldStudentList, newStudentList) -> {
                            oldStudentList.addAll(newStudentList);
                            return oldStudentList;
                        }))
                .entrySet().stream().max(Comparator.comparingInt(e -> e.getValue().size())).get().getKey();
    }

    @Override
    public Integer countGroupsWithOnlyAdultStudents(List<Student> students) {
        return Math.toIntExact(
                students.stream().collect(Collectors.groupingBy(Student::getGroup,Collectors.toList()))
                        .entrySet().stream()
                        .filter(e->e.getValue().size()!=0 && e.getValue().size()
                                == e.getValue().stream().filter(s->LocalDate.from(s.getBirthdayDate()).getYear()>=18)
                                .count()).count());
    }

    @Override
    public Map<String, Integer> getGroupScoreSumMap(List<Student> students, String studentSurname) {
        return students.stream()
                .filter(student -> student.getFullName().split(" ")[0].equals(studentSurname))
                .collect(Collectors.toMap(student -> student.getGroup().getTitle(),student->1, Integer::sum));
    }

    @Override
    public Map<Boolean, Map<String, Integer>> groupStudentScoreWithThreshold(List<Student> students, Integer threshold) {
        return students.stream()
                .collect(
                        Collectors.groupingBy(student -> student.getScore() > threshold,
                                Collectors.toMap(Student::getFullName,Student::getScore)));
    }
}