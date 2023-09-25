package org.lumijiez.managers;

import org.lumijiez.base.Faculty;
import org.lumijiez.base.Grade;
import org.lumijiez.base.Group;
import org.lumijiez.util.FullStudentData;
import org.lumijiez.base.Student;

import java.io.Serializable;

public class Supervisor implements Serializable {
    private final FacultyManager fm;

    public Supervisor() {
        this.fm = new FacultyManager();
    }

    public String getStudentsText() {
        StringBuilder info = new StringBuilder();
        for (Group group : fm.getGm().getGroups()) {
            for (Student student : group.getStudents()) {
                info.append(student.getFullname()).append(" ").append(student.getGroup().getName()).append("\n");
            }
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
