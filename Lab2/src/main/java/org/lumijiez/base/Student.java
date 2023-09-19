package org.lumijiez.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private final String name;
    private final String surname;
    private final String fullname;
    private Group group;
    private final List<Grade> grades = new ArrayList<>();

    public Student(String name, String surname, Group group) {
        this.name = name;
        this.surname = surname;
        this.fullname = name + " " + surname;
        this.group = group;
    }

    public void setGroup(Group gr) {
        this.group.deleteStudent(this);
        this.group = gr;
        gr.addStudent(this);
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullname() {
        return fullname;
    }

    public Group getGroup() {
        return group;
    }

}
