package org.lumijiez.base;

import org.lumijiez.util.FullStudentData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student implements Serializable {

    public Student(String name, String surname, Group group, Faculty faculty, Date birth, Date enrol) {
        this.name = name;
        this.surname = surname;
        this.fullname = name + " " + surname;
        this.group = group;
        this.faculty = faculty;
        this.dateOfBirth = birth;
        this.enrollmentDate = enrol;
        this.FSD = new FullStudentData(name, surname, group.getName(), faculty.getName());
    }


    private String name;
    private String surname;
    private String fullname;
    private String email;
    private Date enrollmentDate;
    private Date dateOfBirth;
    private Faculty faculty;
    private Group group;
    // This acts like an identification serial number for each student
    private FullStudentData FSD;
    private final List<Grade> grades = new ArrayList<>();


    // Student stores a reference to its own Group and Faculty, bidirectional association

    public Faculty getFaculty() {
        return faculty;
    }

    public FullStudentData getFSD() {
        return FSD;
    }

    public void setFSD(FullStudentData FSD) {
        this.FSD = FSD;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }


    public void setGroup(Group gr) {
        this.group.deleteStudent(this);
        this.group = gr;
        gr.addStudent(this);
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Group getGroup() {
        return group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return fullname;
    }

}
