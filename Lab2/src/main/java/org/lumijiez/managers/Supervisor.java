package org.lumijiez.managers;

import org.lumijiez.base.Grade;
import org.lumijiez.base.Group;
import org.lumijiez.util.NameSurnameGroup;
import org.lumijiez.base.Student;

import java.io.Serializable;

public class Supervisor implements Serializable {
    private final FacultyManager fm;

    public Supervisor() {
        this.groupManager = new FacultyManager();
    }

    public String getStudentsText() {
        StringBuilder info = new StringBuilder();
        for (Group group : groupManager.getGroups()) {
            for (Student student : group.getStudents()) {
                info.append(student.getFullname()).append(" ").append(student.getGroup().getName()).append("\n");
            }
        }
        return info.toString();
    }

    public String getGradesText(NameSurnameGroup NSG) {
        StringBuilder info = new StringBuilder();
        for (Grade grade : groupManager.getGroup(NSG.group()).getStudent(NSG.name(), NSG.surname()).getGrades()) {
            info.append(grade.getSubject()).append(" ").append(grade.getGrade());
        }
        return info.toString();
    }

    public void changeGroup(NameSurnameGroup NSG, String groupName) {
        Group gr = groupManager.findGroup(groupName);
        groupManager.getGroup(groupName).getStudent(NSG.name(), NSG.surname()).setGroup(gr);
    }

    public void addStudent(NameSurnameGroup NSG) {
        Group currentGroup = groupManager.getGroup(NSG.group());
        currentGroup.addStudent(new Student(NSG.name(), NSG.surname(), currentGroup));
    }

    public void addGrade(NameSurnameGroup NSG, Grade grade) {
        Student student = groupManager.getGroup(NSG.group()).getStudent(NSG.name(), NSG.surname());
        student.addGrade(grade);
    }

}
