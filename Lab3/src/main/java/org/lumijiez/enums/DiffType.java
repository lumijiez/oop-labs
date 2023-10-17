package org.lumijiez.enums;

public enum DiffType {
    CREATE(StateType.NEW), DELETE(StateType.DELETED), MODIFY(StateType.MODIFIED), NONE(StateType.NONE);

    private final StateType type;

    DiffType(StateType type) {
        this.type = type;
    }

    public StateType getState() {
        return type;
    }
}
