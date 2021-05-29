package itis.q32;

import itis.q32.entities.Group;
import itis.q32.entities.Student;

import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {


    @Override
    public Group getSmallestGroup(List<Student> students) {
        return null;
    }

    @Override
    public Integer countGroupsWithOnlyAdultStudents(List<Student> students) {
        return null;
    }

    @Override
    public Map<String, Integer> getGroupScoreSumMap(List<Student> students, String studentSurname) {
        return null;
    }

    @Override
    public Map<Boolean, Map<String, Integer>> groupStudentScoreWithThreshold(List<Student> students, Integer threshold) {
        return null;
    }
}
