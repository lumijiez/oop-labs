/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.lumijiez.gui.forms.student;

import org.lumijiez.managers.Supervisor;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GradeStudentForm extends JFrame {

    private final Supervisor sv;
    private final JLabel mainTextLabel;
    private final JButton cancelButton = new JButton();
    private final JTextField gradeField = new JTextField();
    private final JLabel gradeLabel = new JLabel();
    private final JComboBox<String> studentCombo = new JComboBox<>();
    private final JLabel studentLabel = new JLabel();
    private final JComboBox<String> subjectCombo = new JComboBox<>();
    private final JLabel subjectLabel = new JLabel();
    private final JButton submitButton = new JButton();
    private final JLabel titleLabel = new JLabel();

    public GradeStudentForm(Supervisor sv, JLabel mainTextLabel) {
        this.sv = sv;
        this.mainTextLabel = mainTextLabel;
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("sansserif", 0, 18));

        titleLabel.setText("Grade a student");
        studentLabel.setText("Student:");
        subjectLabel.setText("Subject:");
        gradeField.setText("Grade...");
        submitButton.setText("Submit");
        gradeLabel.setText("Grade:");
        cancelButton.setText("Cancel");

        submitButton.setBackground(new java.awt.Color(204, 255, 204));
        cancelButton.setBackground(new java.awt.Color(255, 204, 204));

        submitButton.addActionListener(this::submitButtonActionPerformed);
        cancelButton.addActionListener(this::cancelButtonActionPerformed);

        studentCombo.setModel(new DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        subjectCombo.setModel(new DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(gradeLabel)
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(studentCombo, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(studentLabel)
                                                        .addComponent(gradeField, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                                                .addComponent(subjectLabel)
                                                                .addGap(148, 148, 148))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(cancelButton)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(submitButton))
                                                                        .addComponent(subjectCombo, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(titleLabel)
                                .addGap(0, 0, Short.MAX_VALUE)));

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(titleLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(subjectLabel)
                                        .addComponent(studentLabel))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(studentCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(subjectCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(gradeLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(gradeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cancelButton)
                                        .addComponent(submitButton))
                                .addContainerGap(30, Short.MAX_VALUE)));
        pack();
    }

    private void submitButtonActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        this.dispose();
    }

}
