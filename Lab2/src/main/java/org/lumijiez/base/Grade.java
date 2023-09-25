package org.lumijiez.base;

import java.io.Serializable;

public class Grade implements Serializable {
    private String subject;
    private int grade;

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

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
