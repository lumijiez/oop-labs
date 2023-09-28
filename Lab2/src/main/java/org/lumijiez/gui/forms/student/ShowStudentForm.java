/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.lumijiez.gui.forms.student;

import org.lumijiez.base.Student;
import org.lumijiez.gui.util.ComponentDecorator;
import org.lumijiez.managers.Supervisor;
import org.lumijiez.gui.util.ComboBoxRenderers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class ShowStudentForm extends JFrame {
    private final JTextArea mainTextLabel;
    private final JButton cancelButton = new JButton();
    private final JComboBox<Student> studentCombo;
    private final JLabel studentLabel = new JLabel();
    private final JButton submitButton = new JButton();
    private final JLabel titleLabel = new JLabel();

    public ShowStudentForm(Supervisor sv, JTextArea mainTextLabel) {
        this.mainTextLabel = mainTextLabel;
        this.studentCombo = new JComboBox<>(sv.getFm().getGm().getSm().getStudents().toArray(new Student[0]));
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("sansserif", Font.PLAIN, 18)); // NOI18N

        titleLabel.setText("Show Student");
        submitButton.setText("Submit");
        studentLabel.setText("Student:");
        cancelButton.setText("Cancel");

        ComponentDecorator.submitButton(submitButton);
        ComponentDecorator.cancelButton(cancelButton);

        submitButton.addActionListener(this::submitButtonActionPerformed);
        cancelButton.addActionListener(this::cancelButtonActionPerformed);

        ComboBoxRenderers.setStudentRenderer(studentCombo);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(5, 5, 5)
                                                                .addComponent(studentLabel))
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(cancelButton)
                                                                        .addGap(34, 34, 34)
                                                                        .addComponent(submitButton))
                                                                .addComponent(studentCombo, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(52, 52, 52)
                                                .addComponent(titleLabel)))
                                .addContainerGap(23, Short.MAX_VALUE)));

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel)
                                .addGap(13, 13, 13)
                                .addComponent(studentLabel)
                                .addGap(3, 3, 3)
                                .addComponent(studentCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton)
                                        .addComponent(submitButton))
                                .addContainerGap(22, Short.MAX_VALUE)));
        pack();
    }

    private void submitButtonActionPerformed(ActionEvent evt) {
        Student student = ((Student) Objects.requireNonNull(studentCombo.getSelectedItem()));
        StringBuilder text = new StringBuilder();

        text.append("==================== Student Info ======================\n");
        mainTextLabel.setText(text.toString());
        text.append("Name: ").append(student.getFullname()).append(" \n")
                .append("Group: ").append(student.getGroup().getName())
                .append(" \nFaculty: ").append(student.getFaculty().getName())
                .append(" \nEmail: ").append(student.getEmail()).append(" \n")
                .append("Bday: ").append(student.getDateOfBirth())
                .append("\nEnrol date: ").append(student.getEnrollmentDate())
                .append("\nGraduated: ").append(student.isGraduated());
        text.append("\n==================================================");
        mainTextLabel.setText(text.toString());
        this.dispose();
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        this.dispose();
    }

}
