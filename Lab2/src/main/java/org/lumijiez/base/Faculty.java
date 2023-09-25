package org.lumijiez.base;

import org.lumijiez.enums.StudyField;

import java.util.List;

public class Faculty {

    public Faculty(String name, String abbreviation, StudyField field) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.field = field;
    }

    private String name;
    private String abbreviation;
    private List<Group> groups;
    private StudyField field;

    public void addGroup(Group group) {
        groups.add(group);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public StudyField getField() {
        return field;
    }

    public void setField(StudyField field) {
        this.field = field;
    }

}
