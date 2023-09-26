/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.lumijiez.gui.forms.student;

import org.lumijiez.base.Faculty;
import org.lumijiez.base.Group;
import org.lumijiez.base.Student;
import org.lumijiez.managers.Supervisor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Objects;

public class EditStudentForm extends JFrame {

    private final Supervisor sv;
    private final JLabel mainTextLabel;
    private final JButton cancelButton = new JButton();
    private final JTextField emailField = new JTextField();
    private final JLabel emailLabel = new JLabel();
    private final JComboBox<Faculty> facultyCombo;
    private final JLabel facultyLabel = new JLabel();
    private final JComboBox<Group> groupCombo;
    private final JLabel groupLabel = new JLabel();
    private final JTextField nameField = new JTextField();
    private final JLabel nameLabel = new JLabel();
    private final JComboBox<Student> studentCombo;
    private final JLabel studentLabel = new JLabel();
    private final JButton submitButton = new JButton();
    private final JTextField surnameField = new JTextField();
    private final JLabel surnameLabel = new JLabel();
    private final JLabel titleLabel = new JLabel();

    public EditStudentForm(Supervisor sv, JLabel mainTextLabel) {
        this.sv = sv;
        this.mainTextLabel = mainTextLabel;
        this.facultyCombo = new JComboBox<>(sv.getFm().getFaculties().toArray(new Faculty[0]));
        this.groupCombo = new JComboBox<>(sv.getFm().getGm().getGroups().toArray(new Group[0]));
        this.studentCombo = new JComboBox<>(sv.getFm().getGm().getSm().getStudents().toArray(new Student[0]));
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        titleLabel.setText("Edit a student");
        nameField.setText("Name...");
        submitButton.setText("Submit");
        cancelButton.setText("Cancel");
        studentLabel.setText("Student:");
        surnameField.setText("Surname...");
        emailField.setText("Email...");
        nameLabel.setText("New name:");
        emailLabel.setText("New email:");
        groupLabel.setText("New group:");
        facultyLabel.setText("New faculty:");
        surnameLabel.setText("New surname:");

        submitButton.setBackground(new java.awt.Color(204, 255, 204));
        submitButton.addActionListener(this::submitButtonActionPerformed);

        cancelButton.setBackground(new java.awt.Color(255, 204, 204));
        cancelButton.addActionListener(this::cancelButtonActionPerformed);

        facultyCombo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Faculty)
                    setText(((Faculty) value).getName());
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });

        groupCombo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Group)
                    setText(((Group) value).getName());
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });

        studentCombo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Student)
                    setText(((Student) value).getName());
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(studentLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(surnameLabel)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(surnameField, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                                                        .addComponent(nameLabel)
                                                                        .addComponent(nameField, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                                                        .addComponent(studentCombo, GroupLayout.Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(36, 36, 36)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(emailLabel)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(cancelButton)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(submitButton))
                                                                                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(groupCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(groupLabel))
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(facultyLabel)
                                                                                                .addComponent(facultyCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(162, 162, 162)
                                                .addComponent(titleLabel)))
                                .addContainerGap(24, Short.MAX_VALUE)));

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(titleLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(studentLabel)
                                        .addComponent(groupLabel)
                                        .addComponent(facultyLabel))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(studentCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(groupCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(facultyCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(emailLabel)
                                        .addComponent(nameLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(surnameLabel)
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(surnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cancelButton)
                                        .addComponent(submitButton))
                                .addContainerGap(24, Short.MAX_VALUE)));
        pack();
    }

    private void submitButtonActionPerformed(ActionEvent evt) {
        String name = nameField.getText();
        String surname = surnameField.getText();
        Group group = (Group) Objects.requireNonNull(groupCombo.getSelectedItem());
        Faculty faculty = ((Faculty) Objects.requireNonNull(facultyCombo.getSelectedItem()));
//        int birthYear = Integer.parseInt(birthYearField.getText());
//        int birthMonth = Integer.parseInt(birthMonthField.getText());
//        int birthDay = Integer.parseInt(birthDayField.getText());
//        int enrolYear = Integer.parseInt(enrolYearField.getText());
//        int enrolMonth = Integer.parseInt(enrolMonthField.getText());
//        int enrolDay = Integer.parseInt(enrolDayField.getText());
//        Date birthDate = new Date(birthYear, birthMonth, birthDay);
//        Date enrolDate = new Date(enrolYear, enrolMonth, enrolDay);
//        sv.addStudent(name, surname, group, faculty, birthDate, enrolDate);
        this.dispose();
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        this.dispose();
    }

}
