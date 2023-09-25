package org.lumijiez.gui.forms;

import org.lumijiez.managers.Supervisor;
import org.lumijiez.util.FullStudentData;

import javax.swing.*;
import java.awt.*;

public class ChangeGroupForm extends JFrame {
    public ChangeGroupForm(int centerX, int centerY, Supervisor sv, JTextArea outputTextArea) {
        this.setTitle("Change Group");
        this.setSize(400, 300);
        this.setLocation(centerX, centerY);

        JPanel formPanel = new JPanel(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel surnameLabel = new JLabel("Surname:");
        JTextField surnameField = new JTextField();
        JLabel groupLabel = new JLabel("Group:");
        JTextField groupField = new JTextField();
        JLabel facultyLabel = new JLabel("Faculty:");
        JTextField facultyField = new JTextField();
        JLabel newgroupLabel = new JLabel("New Group:");
        JTextField newgroupField = new JTextField();
        JButton submitButton = new JButton("Submit");

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(surnameLabel);
        formPanel.add(surnameField);
        formPanel.add(groupLabel);
        formPanel.add(groupField);
        formPanel.add(facultyLabel);
        formPanel.add(facultyField);
        formPanel.add(newgroupLabel);
        formPanel.add(newgroupField);
        formPanel.add(submitButton);

        this.add(formPanel);

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String surname = surnameField.getText();
            String group = groupField.getText();
            String newgroup = newgroupField.getText();
            String faculty = facultyField.getText();
            FullStudentData data = new FullStudentData(name, surname, group, faculty);
            if (!name.isEmpty() && !surname.isEmpty() && !group.isEmpty() && !newgroup.isEmpty()) {
                //studentManager.changeGroup(new NameSurnameGroup(name, surname, group), newgroup);
                outputTextArea.setText("===== Groups =====\n" + sv.getGroupsText());
                this.dispose();
            } else JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        });
        this.setVisible(true);
    }

}