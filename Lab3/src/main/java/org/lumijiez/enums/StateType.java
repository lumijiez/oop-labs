package org.lumijiez.enums;

public enum StateType {
    NEW("Created"), MODIFIED("Modified"), DELETED("Deleted"), NONE("Nothing");

    private final String action;
    StateType(String name) {
        this.action = name;
    }

    public String getAction() {
        return this.action;
    }
}
