package org.lumijiez.managers;

import org.lumijiez.base.Group;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GroupManager implements Serializable {
    private final List<Group> groups = new ArrayList<>();

    public Group getGroup(String groupName) {
        for (Group group : groups) {
            if (group.getName().equals(groupName)) {
                return group;
            }
        }
        Group newGroup = new Group(groupName);
        groups.add(newGroup);
        return newGroup;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void deleteGroup(Group group) {
        groups.remove(group);
    }

}
