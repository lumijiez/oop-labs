package org.lumijiez.managers;

import org.lumijiez.base.Faculty;
import org.lumijiez.base.Grade;
import org.lumijiez.base.Group;
import org.lumijiez.base.Student;

import java.io.Serializable;
import java.util.Date;

public class Supervisor implements Serializable {

    private final FacultyManager fm;

    private final LogManager logger;

    public Supervisor() {
        this.fm = new FacultyManager();
        this.logger = new LogManager();
    }

    public void addFaculty(Faculty faculty) {
        getFm().addFaculty(faculty);
        logger.logOperation("Faculty added: " + faculty.getName());
    }

    public void deleteFaculty(Faculty faculty) {
        fm.deleteFaculty(faculty);
        for (Group gr : faculty.getGroups()) {
            getFm().getGm().deleteGroup(gr);
            for (Student st : gr.getStudents()) {
                getFm().getGm().getSm().deleteStudent(st);
            }
        }
        logger.logOperation("Faculty deleted : " + faculty.getName());
    }

    public void addGrade(Student student, Grade grade) {
        student.addGrade(grade);
        logger.logOperation("Student graded: " + student.getName() + " " + grade.getSubject().getName() + " " + grade.getGrade());
    }

    public void editGroup(Group group, String name, Faculty faculty) {
        group.setName(name);
        Faculty oldFac = group.getFaculty();
        group.setFaculty(faculty);
        faculty.addGroup(group);
        oldFac.getGroups().remove(group);
        logger.logOperation("Group edited: " + group.getName());
    }

    public void deleteGroup(Group group) {
        getFm().getGm().deleteGroup(group);
        for (Student st : group.getStudents()) {
            getFm().getGm().getSm().deleteStudent(st);
        }
        logger.logOperation("Group deleted: " + group.getName());
    }

    public void addStudent(String name, String surname, String email, Group group, Faculty faculty, Date birth, Date enrol) {
        Student newStudent = new Student(name, surname, email, group, faculty, birth, enrol);
        getFm().getGm().getSm().addStudent(newStudent);
        logger.logOperation("Student added: " + newStudent.getFullname());
    }

    public void editStudent(Student student, String name, String surname, String email, Group group, Faculty faculty, Date birth, Date enrol) {
        student.getGroup().deleteStudent(student);
        student.setName(name);
        student.setSurname(surname);
        student.setFullname(name + " " + surname);
        student.setEmail(email);
        student.setGroup(group);
        group.addStudent(student);
        student.setFaculty(faculty);
        student.setDateOfBirth(birth);
        student.setEnrollmentDate(enrol);
        logger.logOperation("Student edited: " + student.getFullname());
    }

    public void addGroup(Group group, Faculty faculty) {
        group.setFaculty(faculty);
        faculty.addGroup(group);
        getFm().getGm().addGroup(group);
        logger.logOperation("Group added: " + group.getName());
    }

    public void deleteStudent(Student st) {
        st.getGroup().deleteStudent(st);
        getFm().getGm().getSm().deleteStudent(st);
        logger.logOperation("Student deleted: " + st.getFullname());
    }

    public Faculty getFacultyByName(String facultyName) {
        for (Faculty faculty : getFm().getFaculties()) {
            if (faculty.getName().equals(facultyName))
                return faculty;
        }
        return null;
    }

    public Group getGroupByName(String groupName, Faculty faculty) {
        for (Group group : getFm().getGm().getGroups()) {
            if (group.getName().equals(groupName) && group.getFaculty().equals(faculty))
                return group;
        }
        return null;
    }

    public FacultyManager getFm() {
        return fm;
    }

    public LogManager getLogger() {
        return this.logger;
    }

}
