package org.lumijiez.managers;

import org.lumijiez.base.Faculty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FacultyManager implements Serializable {

    public FacultyManager(GroupManager gm, StudentManager sm) {
        this.gm = new GroupManager(sm);
        this.sm = sm;
    }
    private final GroupManager gm;
    private final StudentManager sm;
    private final List<Faculty> faculties = new ArrayList<>();

    public Faculty getFaculty(String facultyName, GroupManager gm) {
        for (Faculty fc : faculties)
            if (fc.getName().equals(facultyName)) return fc;
        return null;
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void deleteFaculty(Faculty faculty) {
        faculties.remove(faculty);
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public String getFacultiesText() {
        StringBuilder builder = new StringBuilder();
        for (Faculty fc : faculties)
            builder.append(fc.getName()).append("\n");
        return builder.toString();
    }


}
