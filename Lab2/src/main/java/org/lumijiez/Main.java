package org.lumijiez;

import org.lumijiez.gui.StudentManagementGUI;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentManagementGUI::new);
    }
}
