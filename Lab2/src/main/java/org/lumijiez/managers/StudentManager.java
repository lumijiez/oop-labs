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

    public void addStudent(FullStudentData data, Supervisor sv) {
        Faculty faculty;
        Group group;

        if (Objects.isNull(sv.getFm().getFaculty(data.faculty()))) {
            Faculty newFaculty = new Faculty(data.faculty(), DEFAULT_UNASSIGNED.getAbbreviation(), DEFAULT_UNASSIGNED);
            sv.getFm().addFaculty(newFaculty);
            faculty = newFaculty;
        } else {
            faculty = sv.getFm().getFaculty(data.faculty());
        }

        if (Objects.isNull(sv.getFm().getGm().getGroup(data.group()))) {
            Group newGroup = new Group("Unassigned");
            sv.getFm().getGm().addGroup(newGroup);
            group = newGroup;
        } else {
            group = sv.getFm().getGm().getGroup(data.group());
        }

        Student newStudent = new Student(data.name(), data.surname(), group, faculty);
        students.add(newStudent);
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

    public void deleteStudent(FullStudentData data) {
        students.removeIf(student ->
                student.getName().equals(data.name()) &&
                        student.getSurname().equals(data.surname()) &&
                        student.getGroup().getName().equals(data.group()) &&
                        student.getFaculty().getName().equals(data.faculty())
        );
    }

}
