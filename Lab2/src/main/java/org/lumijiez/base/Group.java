package org.lumijiez.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable {
    private final String name;
    private final List<Student> students = new ArrayList<>();

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
        for (Student student : students) {
            if (student.getName().equals(name) && student.getSurname().equals(surname)) {
                return student;
            }
        }
        return null;
    }
}
