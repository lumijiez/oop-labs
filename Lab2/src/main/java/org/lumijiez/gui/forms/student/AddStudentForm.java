/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.lumijiez.gui.forms.student;

import org.lumijiez.base.Faculty;
import org.lumijiez.base.Group;
import org.lumijiez.managers.Supervisor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Objects;

public class AddStudentForm extends JFrame {

    private final Supervisor sv;
    private final JLabel titleLabel = new JLabel();
    private final JComboBox<Group> groupCombo;
    private final JTextField nameField = new javax.swing.JTextField();
    private final JButton submitButton = new javax.swing.JButton();
    private final JButton cancelButton = new javax.swing.JButton();
    private final JLabel nameLabel = new javax.swing.JLabel();
    private final JTextField surnameField = new javax.swing.JTextField();
    private final JTextField emailField = new javax.swing.JTextField();
    private final JLabel surnameLabel = new javax.swing.JLabel();
    private final JLabel emailLabel = new javax.swing.JLabel();
    private final JComboBox<Faculty> facultyCombo;
    private final JLabel groupLabel = new javax.swing.JLabel();
    private final JLabel facultyLabel = new javax.swing.JLabel();
    private final JTextField birthYearField = new javax.swing.JTextField();
    private final JTextField birthDayField = new javax.swing.JTextField();
    private final JTextField birthMonthField = new javax.swing.JTextField();
    private final JLabel surnameLabel1 = new javax.swing.JLabel();
    private final JLabel birthDayLabel = new javax.swing.JLabel();
    private final JLabel birthMonthLabel = new javax.swing.JLabel();
    private final JLabel enrolDayLabel = new javax.swing.JLabel();
    private final JTextField enrolDayField = new javax.swing.JTextField();
    private final JTextField enrolMonthField = new javax.swing.JTextField();
    private final JLabel enrolMonthLabel = new javax.swing.JLabel();
    private final JTextField enrolYearField = new javax.swing.JTextField();
    private final JLabel enrolYearLabel = new javax.swing.JLabel();
    public AddStudentForm(Supervisor sv) {
        this.sv = sv;
        facultyCombo = new JComboBox<>(sv.getFm().getFaculties().toArray(new Faculty[0]));
        groupCombo = new JComboBox<>(sv.getFm().getGm().getGroups().toArray(new Group[0]));
        initComponents();
    }

    private void initComponents() {



        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        titleLabel.setText("Add a new student");

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

        nameField.setText("Name...");

        submitButton.setBackground(new java.awt.Color(204, 255, 204));
        submitButton.setText("Submit");
        submitButton.addActionListener(this::submitButtonActionPerformed);

        cancelButton.setBackground(new java.awt.Color(255, 204, 204));
        cancelButton.setText("Cancel");

        nameLabel.setText("Name:");

        surnameField.setText("Surname...");

        emailField.setText("Email...");

        surnameLabel.setText("Surname:");

        emailLabel.setText("Email:");

        groupLabel.setText("Group:");

        facultyLabel.setText("Faculty:");

        birthYearField.setText("Surname...");

        birthDayField.setText("Surname...");

        birthMonthField.setText("Surname...");

        surnameLabel1.setText("Year of Birth:");

        birthDayLabel.setText("Day of Birth:");

        birthMonthLabel.setText("Month of Birth:");

        enrolDayLabel.setText("Day of Enrollment:");

        enrolDayField.setText("Surname...");

        enrolMonthField.setText("Surname...");

        enrolMonthLabel.setText("Month of Enrollment:");

        enrolYearField.setText("Surname...");

        enrolYearLabel.setText("Year of Enrollment:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(132, 132, 132)
                                                .addComponent(titleLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(surnameLabel)
                                                .addGap(142, 142, 142)
                                                .addComponent(emailLabel)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(surnameField, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                                        .addComponent(nameField)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(5, 5, 5)
                                                                .addComponent(nameLabel))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(birthDayField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(birthDayLabel))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(birthMonthLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(birthMonthField))))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(groupLabel)
                                                                .addGap(67, 67, 67)
                                                                .addComponent(facultyLabel)
                                                                .addGap(51, 51, 51))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(groupCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(34, 34, 34)
                                                                                                .addComponent(facultyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(cancelButton)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(submitButton))))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(32, 32, 32)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(surnameLabel1)
                                                                                        .addComponent(birthYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(enrolDayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(enrolDayField))
                                                .addGap(29, 29, 29)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(enrolMonthLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(enrolMonthField, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                                                .addGap(55, 55, 55)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(enrolYearField, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                                                .addGap(43, 43, 43))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(enrolYearLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel)
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameLabel)
                                        .addComponent(groupLabel)
                                        .addComponent(facultyLabel))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(groupCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(facultyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(surnameLabel)
                                                .addGap(5, 5, 5))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(emailLabel)
                                                .addGap(4, 4, 4)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(birthDayLabel)
                                        .addComponent(birthMonthLabel)
                                        .addComponent(surnameLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(birthDayField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(birthMonthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(birthYearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(enrolDayLabel)
                                        .addComponent(enrolMonthLabel)
                                        .addComponent(enrolYearLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(enrolDayField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(enrolMonthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(enrolYearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton)
                                        .addComponent(submitButton))
                                .addGap(21, 21, 21))
        );

        pack();
    }

    private void submitButtonActionPerformed(ActionEvent evt) {
        String name = nameField.getText();
        String surname = surnameField.getText();
        Group group = (Group) Objects.requireNonNull(groupCombo.getSelectedItem());
        Faculty faculty = ((Faculty) Objects.requireNonNull(facultyCombo.getSelectedItem()));
        int birthYear = Integer.parseInt(birthYearField.getText());
        int birthMonth = Integer.parseInt(birthMonthField.getText());
        int birthDay = Integer.parseInt(birthDayField.getText());
        int enrolYear = Integer.parseInt(enrolYearField.getText());
        int enrolMonth = Integer.parseInt(enrolMonthField.getText());
        int enrolDay = Integer.parseInt(enrolDayField.getText());
        Date birthDate = new Date(birthYear, birthMonth, birthDay);
        Date enrolDate = new Date(enrolYear, enrolMonth, enrolDay);
        sv.addStudent(name, surname, group, faculty, birthDate, enrolDate);
        this.dispose();
    }

}
