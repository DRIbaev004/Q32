package itis.q32.entities;

import java.time.LocalDate;

public class Student {


    //ФИО
    private String fullName;

    private Group group;

    private Integer score;

    private LocalDate birthdayDate;


    public Student(String fullName, Group group, Integer score, LocalDate birthdayDate) {
        this.fullName = fullName;
        this.group = group;
        this.score = score;
        this.birthdayDate = birthdayDate;
    }

    public Student() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(LocalDate birthdayDate) {
        this.birthdayDate = birthdayDate;
    }
}
