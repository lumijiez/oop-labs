package org.lumijiez.gui.forms;

import org.lumijiez.base.NameSurnameGroup;
import org.lumijiez.managers.Manager;

import javax.swing.*;
import java.awt.*;

public class AddStudentForm extends JFrame {
    public AddStudentForm(int centerX, int centerY, Manager studentManager, JTextArea outputTextArea) {
        this.setTitle("Add Student");
        this.setSize(400, 300);
        this.setLocation(centerX, centerY);

        JPanel formPanel = new JPanel(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel surnameLabel = new JLabel("Surname:");
        JTextField surnameField = new JTextField();
        JLabel groupLabel = new JLabel("Group:");
        JTextField groupField = new JTextField();
        JButton submitButton = new JButton("Submit");

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(surnameLabel);
        formPanel.add(surnameField);
        formPanel.add(groupLabel);
        formPanel.add(groupField);
        formPanel.add(submitButton);

        this.add(formPanel);

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String surname = surnameField.getText();
            String group = groupField.getText();
            if (!name.isEmpty() && !surname.isEmpty() && !group.isEmpty()) {
                studentManager.addStudent(new NameSurnameGroup(name, surname, group));
                outputTextArea.setText("===== Students =====\n" + studentManager.getStudentsText());
                this.dispose();
            } else JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        });
        this.setVisible(true);
    }
}
