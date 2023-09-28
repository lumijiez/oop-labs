package org.lumijiez;

import org.lumijiez.gui.StudentManagementGUI;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.err.println("Windows LAF not found!");
        }

        EventQueue.invokeLater(() -> new StudentManagementGUI().setVisible(true));
    }
}

