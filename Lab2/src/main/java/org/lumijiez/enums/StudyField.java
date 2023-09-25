package org.lumijiez.enums;

public enum StudyField {
    MECHANICAL_ENGINEERING("Mechanical Engineering", "ME"),
    SOFTWARE_ENGINEERING("Software Engineering", "FAF"),
    FOOD_TECHNOLOGY("Food Technology", "FT"),
    URBANISM_ARCHITECTURE("Urbanism and Architecture", "UA"),
    VETERINARY_MEDICINE("Veterinary Medicine", "VE");

    private final String name;

    private final String abbreviation;

    StudyField(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
