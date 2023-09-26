package org.lumijiez.managers;

import org.lumijiez.base.Faculty;
import org.lumijiez.base.Group;
import org.lumijiez.base.Student;
import org.lumijiez.util.FullStudentData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.lumijiez.enums.StudyField.DEFAULT_UNASSIGNED;

public class StudentManager implements Serializable {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        student.getGroup().addStudent(student);
        students.add(student);
    }
    public List<Student> getStudents() {
        return students;
    }

    public Student getStudent(FullStudentData data) {
        for (Student st : students) {
            if (st.getFSD().equals(data)) return st;
        }
        return null;
    }

    public void deleteStudent(Student student) {
        students.remove(student);
    }

}
