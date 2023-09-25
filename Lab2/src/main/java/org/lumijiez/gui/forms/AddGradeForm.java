package org.lumijiez.gui.forms;

import org.lumijiez.base.Grade;
import org.lumijiez.managers.Supervisor;
import org.lumijiez.util.FullStudentData;

import javax.swing.*;
import java.awt.*;

public class AddGradeForm extends JFrame {
    public AddGradeForm(int centerX, int centerY, Supervisor sv, JTextArea outputTextArea) {
        this.setTitle("Add Grade");
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
        JLabel subjectLabel = new JLabel("Subject:");
        JTextField subjectField = new JTextField();
        JLabel gradeLabel = new JLabel("Grade:");
        JTextField gradeField = new JTextField();

        JButton submitButton = new JButton("Submit");


        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(surnameLabel);
        formPanel.add(surnameField);
        formPanel.add(groupLabel);
        formPanel.add(groupField);
        formPanel.add(facultyLabel);
        formPanel.add(facultyField);
        formPanel.add(subjectLabel);
        formPanel.add(subjectField);
        formPanel.add(gradeLabel);
        formPanel.add(gradeField);
        formPanel.add(submitButton);

        this.add(formPanel);

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String surname = surnameField.getText();
            String group = groupField.getText();
            String subject = subjectField.getText();
            String grade = gradeField.getText();
            String faculty = facultyField.getText();
            FullStudentData data = new FullStudentData(name, surname, group, faculty);
            if (!name.isEmpty() && !surname.isEmpty() && !group.isEmpty() && !subject.isEmpty() && !grade.isEmpty() && !faculty.isEmpty()) {
                sv.getFm().getGm().getSm().getStudent(data).addGrade(new Grade(subject, Integer.parseInt(grade)));
                outputTextArea.setText("===== Students =====\n" + sv.getStudentsText());
                this.dispose();
            } else JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        });
        this.setVisible(true);
    }
}
