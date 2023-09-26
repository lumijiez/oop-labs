package org.lumijiez.managers;

import org.lumijiez.base.Faculty;
import org.lumijiez.base.Grade;
import org.lumijiez.base.Group;
import org.lumijiez.util.FullStudentData;
import org.lumijiez.base.Student;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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

    public void addStudent(String name, String surname, Group group, Faculty faculty, Date birth, Date enrol) {
        Student newStudent = new Student(name, surname, group, faculty, birth, enrol);
        getFm().getGm().getSm().addStudent(newStudent);
        group.addStudent(newStudent);
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

    public String getStudentsText() {
        StringBuilder info = new StringBuilder();
        for (Student st : fm.getGm().getSm().getStudents()) {
            info.append(st.getFullname()).append(" ").append(st.getGroup().getName()).append("\n");
        }
        return info.toString();
    }

    public String getGradesText(FullStudentData data) {
        StringBuilder info = new StringBuilder();
        for (Grade gr : fm.getGm().getSm().getStudent(data).getGrades()) {
            info.append(gr.getSubject()).append(" ").append(gr.getGrade());
        }
        return info.toString();
    }

    public String getGroupsText() {
        StringBuilder builder = new StringBuilder();
        for (Group gr : fm.getGm().getGroups())
            builder.append(gr.getName()).append("\n");
        return builder.toString();
    }

    public String getFacultiesText() {
        StringBuilder builder = new StringBuilder();
        for (Faculty fc : fm.getFaculties())
            builder.append(fc.getName()).append("\n");
        return builder.toString();
    }

    public FacultyManager getFm() {
        return fm;
    }

//    public void changeGroup(NameSurnameGroup NSG, String groupName) {
//        Group gr = groupManager.findGroup(groupName);
//        groupManager.getGroup(groupName).getStudent(NSG.name(), NSG.surname()).setGroup(gr);
//    }

//    public void addStudent(NameSurnameGroup NSG) {
//        Group currentGroup = groupManager.getGroup(NSG.group());
//        currentGroup.addStudent(new Student(NSG.name(), NSG.surname(), currentGroup));
//    }

//    public void addGrade(NameSurnameGroup NSG, Grade grade) {
//        Student student = groupManager.getGroup(NSG.group()).getStudent(NSG.name(), NSG.surname());
//        student.addGrade(grade);
//    }


}
