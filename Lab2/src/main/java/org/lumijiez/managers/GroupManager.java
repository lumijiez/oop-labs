package org.lumijiez.managers;

import org.lumijiez.base.Group;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GroupManager implements Serializable {

    public GroupManager(StudentManager sm) {
        this.sm = sm;
    }

    private final StudentManager sm;
    private final List<Group> groups = new ArrayList<>();

    public Group getGroup(String groupName) {
        for (Group group : groups)
            if (group.getName().equals(groupName)) return group;
        return null;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void deleteGroup(Group group) {
        groups.remove(group);
    }

    public List<Group> getGroups() {
        return groups;
    }

    public StudentManager getSm() {
        return sm;
    }
}
