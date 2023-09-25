package org.lumijiez.gui.forms;

import org.lumijiez.util.NameSurnameGroup;
import org.lumijiez.managers.Supervisor;

import javax.swing.*;
import java.awt.*;

public class ShowGradesForm extends JFrame {
    public ShowGradesForm(int centerX, int centerY, Supervisor studentManager, JTextArea outputTextArea) {
        this.setTitle("Show Grades Student");
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
                NameSurnameGroup nsg = new NameSurnameGroup(name, surname, group);
                outputTextArea.setText("===== Grades =====\n" + name + " " + surname + "\n" + studentManager.getGradesText(nsg));
                this.dispose();
            } else JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        });
        this.setVisible(true);
    }
}
