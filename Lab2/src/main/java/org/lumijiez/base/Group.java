package org.lumijiez.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable {

    private final List<Student> students = new ArrayList<>();
    private String name;
    //    private String uuid;
    private Faculty faculty;

    public Group(String name) {
        this.name = name;
//        this.uuid = UUID.randomUUID().toString();
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStudent(Student st) {
        students.add(st);
    }

    public void deleteStudent(Student st) {
        students.remove(st);
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return name;
    }

//    public String getUuid() {
//        return uuid;
//    }
//
//    public void setUuid(String uuid) {
//        this.uuid = uuid;
//    }
}
