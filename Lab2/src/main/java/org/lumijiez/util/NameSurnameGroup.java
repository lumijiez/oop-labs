package org.lumijiez.util;

// Helper class for easier management of names, surnames, and groups
public class NameSurnameGroup {
    private final String name;
    private final String surname;
    private final String groupName;

    public NameSurnameGroup(String name, String surname, String groupName) {
        this.name = name;
        this.surname = surname;
        this.groupName = groupName;
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
}
