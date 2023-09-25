package org.lumijiez.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable {
    private String name;

    private Faculty faculty;

    private List<Student> students = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student st) {
        students.add(st);
    }

    public void deleteStudent(Student st) {
        students.remove(st);
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudent(String name, String surname) {
        for (Student student : students)
            if (student.getName().equals(name) && student.getSurname().equals(surname)) {
                return student;
            }
        return null;
    }
}
