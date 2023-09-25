package org.lumijiez.util;


import org.lumijiez.base.Faculty;package org.lumijiez.util;

// Helper class for easier management of names, surnames, and groups
public class FullStudentData {
    private final String name;
    private final String surname;
    private final String groupName;

    private final String facultyName;

    public FullStudentData(String name, String surname, String groupName, String facultyName) {
        this.name = name;
        this.surname = surname;
        this.groupName = groupName;
        this.facultyName = facultyName;
    }

    public String name() {
        return name;
    }

    public String surname() {
        return surname;
    }

    public String group() {
        return groupName;
    }

    public String faculty() {
        return facultyName;
    }
}
