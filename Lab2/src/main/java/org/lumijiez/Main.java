package org.lumijiez;

import org.lumijiez.gui.StudentManagementGUI;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new StudentManagementGUI().setVisible(true));
    }
}
