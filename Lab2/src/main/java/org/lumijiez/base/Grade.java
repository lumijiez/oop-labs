package org.lumijiez.base;

import java.io.Serializable;

public class Grade implements Serializable {
    private final String subject;
    private final int grade;

    public Grade(String subject, int grade) {
        this.subject = subject;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public int getGrade() {
        return grade;
    }

}
