package org.lumijiez.managers;

import org.lumijiez.base.Grade;
import org.lumijiez.base.Group;
import org.lumijiez.base.NameSurnameGroup;
import org.lumijiez.base.Student;

import java.io.Serializable;

public class Manager implements Serializable {
    GroupManager groupManager;

    public Manager() {
        this.groupManager = new GroupManager();
    }

    public void addGroup(String groupName) {
        groupManager.addGroup(new Group(groupName));
    }

    public void addStudent(NameSurnameGroup NSG) {
        Group currentGroup = groupManager.getGroup(NSG.group());
        currentGroup.addStudent(new Student(NSG.name(), NSG.surname(), currentGroup));
    }

    public void printStudents() {
        for (Group group : groupManager.getGroups()) {
            for (Student student : group.getStudents()) {
                System.out.println(student.getFullname() + " " + student.getGroup().getName());
            }
        }
    }

    public void printGroups() {
        for (Group group : groupManager.getGroups()) {
            System.out.println(group.getName());
        }
    }

    public void printGrades(NameSurnameGroup NSG) {
        Student student = groupManager.getGroup(NSG.group()).getStudent(NSG.name(), NSG.surname());
        for (Grade grade : student.getGrades()) {
            System.out.println(grade.getSubject() + " " + grade.getGrade());
        }
    }

    public void addGrade(NameSurnameGroup NSG, Grade grade) {
        Student student = groupManager.getGroup(NSG.group()).getStudent(NSG.name(), NSG.surname());
        student.addGrade(grade);
    }

    public void removeStudent(NameSurnameGroup NSG) {
        Student student = groupManager.getGroup(NSG.group()).getStudent(NSG.name(), NSG.surname());
        groupManager.getGroup(NSG.group()).deleteStudent(student);
        if (student.getGroup().getStudents().isEmpty()) {
            groupManager.getGroups().remove(student.getGroup());
        }
    }
}
