package org.lumijiez.gui.util;

import org.lumijiez.base.Faculty;
import org.lumijiez.base.Group;
import org.lumijiez.base.Student;
import org.lumijiez.gui.StudentManagementGUI;

public class DisplayerManager {
    public static void displayStudents() {
        StringBuilder text = new StringBuilder();
        text.append("==================== Students ======================\n");
        for (Student student : StudentManagementGUI.getSv().getFm().getGm().getSm().getStudents()) {
            text.append("Name: ").append(student.getFullname()).append("\nGroup: ").append(student.getGroup().getName())
                    .append("\nEmail: ").append(student.getEmail()).append("\nGraduated: ").append((student.isGraduated() ? "Yes" : "No"));
            text.append("\n===============================================\n");
        }
        StudentManagementGUI.getMainLabel().setText(text.toString());
    }

    public static void displayGroups() {
        StringBuilder text = new StringBuilder();
        text.append("==================== Groups ======================\n");
        for (Group group : StudentManagementGUI.getSv().getFm().getGm().getGroups()) {
            text.append("Name: ").append(group.getName()).append("\nFaculty: ").append(group.getFaculty().getName())
                    .append("\nNumber of students: ").append(group.getStudents().size());
            text.append("\n===============================================\n");
        }
        StudentManagementGUI.getMainLabel().setText(text.toString());
    }

    public static void displayFaculties() {
        StringBuilder text = new StringBuilder();
        text.append("==================== Faculties ======================\n");
        for (Faculty fac : StudentManagementGUI.getSv().getFm().getFaculties()) {
            text.append("Name: ").append(fac.getName()).append("\nSpecialty: ").append(fac.getField().getName())
                    .append("\nAbbreviation: ").append(fac.getAbbreviation())
                    .append("\nNumber of groups: ").append(fac.getGroups().size());
            text.append("\n===============================================\n");
        }
        StudentManagementGUI.getMainLabel().setText(text.toString());
    }

    public static void displayGraduates() {
        StringBuilder text = new StringBuilder();
        text.append("=================== Students =====================\n");
        for (Student st : StudentManagementGUI.getSv().getFm().getGm().getSm().getStudents()) {
            if (st.isGraduated()) {
                text.append("Name: ").append(st.getFullname()).append("\nGroup: ").append(st.getGroup().getName())
                        .append("\nGraduated: ").append("Yes");
                text.append("\n===============================================\n");
            }
        }
        StudentManagementGUI.getMainLabel().setText(text.toString());
    }

    public static void displayEnrolled() {
        StringBuilder text = new StringBuilder();
        text.append("=================== Students =====================\n");
        for (Student st : StudentManagementGUI.getSv().getFm().getGm().getSm().getStudents()) {
            if (!st.isGraduated()) {
                text.append("Name: ").append(st.getFullname()).append("\nGroup: ").append(st.getGroup().getName())
                        .append("\nGraduated: ").append("No");
                text.append("\n===============================================\n");
            }
        }
        StudentManagementGUI.getMainLabel().setText(text.toString());
    }
}
