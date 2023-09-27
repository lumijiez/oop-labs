package org.lumijiez.enums;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public enum Subjects implements Serializable {
    ENGLISH("English Language", "Eng"),
    LINEAR_ALGEBRA("Linear Algebra", "AL"),
    OBJECT_ORIENTED_PROGRAMMING("Object Oriented Programming", "OOP"),
    DATABASES("Databases", "DB"),
    MATHEMATICAL_ANALYSIS("Mathematical Analysis", "Mat. Anal"),
    DISCRETE_MATH("Discrete Math", "MD"),
    PROBABILITY_AND_STATISTICS("Probability and Statistics", "PSA"),
    PHYSICS("Physics", "PHYS");

    private final String name;

    private final String abbreviation;

    Subjects(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public static String getAbbrevFromString(String str) {
        for (Subjects st : values()) {
            if (st.name.equals(str)) return st.abbreviation;
        }
        return str;
    }

    public static Subjects getEnum(String str) {
        for (Subjects st : values()) {
            if (st.name.equals(str)) return st;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public static List<Subjects> getAllEnums() {
        return Arrays.asList(values());
    }

    @Override
    public String toString() {
        return getName();
    }
}
