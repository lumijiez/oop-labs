package org.lumijiez.util;

public enum StateType {
    NEW("Created"), MODIFIED("Modified"), DELETED("Deleted"), NONE("Nothing");

    private final String name;
    StateType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
