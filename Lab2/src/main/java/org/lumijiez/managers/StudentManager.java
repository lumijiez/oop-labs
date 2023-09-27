package org.lumijiez.managers;

import org.lumijiez.base.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentManager implements Serializable {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        student.getGroup().addStudent(student);
        students.add(student);
    }
    public List<Student> getStudents() {
        return students;
    }

    public void deleteStudent(Student student) {
        students.remove(student);
    }

}
