package org.lumijiez.managers;

import org.lumijiez.base.Faculty;
import org.lumijiez.base.Grade;
import org.lumijiez.base.Group;
import org.lumijiez.base.Student;

import java.io.Serializable;
import java.util.Date;

public class Supervisor implements Serializable {
    private final FacultyManager fm;

    public Supervisor() {
        this.fm = new FacultyManager();
    }

    public void addFaculty(Faculty faculty) {
        getFm().addFaculty(faculty);
    }

    public void deleteFaculty(Faculty faculty) {
        fm.deleteFaculty(faculty);
        for (Group gr : faculty.getGroups()) {
            getFm().getGm().deleteGroup(gr);
            for (Student st : gr.getStudents()) {
                getFm().getGm().getSm().deleteStudent(st);
            }
        }
    }

    public void addGrade(Student student, Grade grade) {
        student.addGrade(grade);
    }

    public void editGroup(Group group, String name, Faculty faculty) {
        group.setName(name);
        Faculty oldFac = group.getFaculty();
        group.setFaculty(faculty);
        faculty.addGroup(group);
        oldFac.getGroups().remove(group);
    }

    public void deleteGroup(Group group) {
        getFm().getGm().deleteGroup(group);
        for (Student st : group.getStudents()) {
            getFm().getGm().getSm().deleteStudent(st);
        }
    }

    public void addStudent(String name, String surname, String email, Group group, Faculty faculty, Date birth, Date enrol) {
        Student newStudent = new Student(name, surname, email, group, faculty, birth, enrol);
        getFm().getGm().getSm().addStudent(newStudent);
    }

    public void editStudent(Student student, String name, String surname, String email, Group group, Faculty faculty) {
        student.getGroup().deleteStudent(student);
        student.setName(name);
        student.setSurname(surname);
        student.setFullname(name + " " + surname);
        student.setEmail(email);
        student.setGroup(group);
        group.addStudent(student);
        student.setFaculty(faculty);
        student.setDateOfBirth(student.getDateOfBirth());
        student.setEnrollmentDate(student.getEnrollmentDate());
    }

    public void addGroup(Group group, Faculty faculty) {
        group.setFaculty(faculty);
        faculty.addGroup(group);
        getFm().getGm().addGroup(group);
    }

    public void deleteStudent(Student st) {
        st.getGroup().deleteStudent(st);
        getFm().getGm().getSm().deleteStudent(st);
    }

    public FacultyManager getFm() {
        return fm;
    }
}
