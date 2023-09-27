package org.lumijiez.gui.util;

import javax.swing.*;

public class ComponentDecorator {
    public static void submitButton(JButton button) {
        button.setBackground(new java.awt.Color(204, 255, 204));
    }

    public static void cancelButton(JButton button) {
        button.setBackground(new java.awt.Color(255, 204, 204));
    }
}
