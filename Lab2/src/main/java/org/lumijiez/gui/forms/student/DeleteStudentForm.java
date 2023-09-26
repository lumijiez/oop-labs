/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.lumijiez.gui.forms.student;

import org.lumijiez.base.Student;
import org.lumijiez.managers.Supervisor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class DeleteStudentForm extends JFrame {
    private final Supervisor sv;
    private final JLabel mainTextLabel;
    private final JButton cancelButton = new JButton();
    private final JComboBox<Student> studentCombo;
    private final JLabel studentLabel = new JLabel();
    private final JButton submitButton = new JButton();
    private final JLabel titleLabel = new JLabel();

    public DeleteStudentForm(Supervisor sv, JLabel mainTextLabel) {
        this.sv = sv;
        this.mainTextLabel = mainTextLabel;
        this.studentCombo = new JComboBox<>(sv.getFm().getGm().getSm().getStudents().toArray(new Student[0]));
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        titleLabel.setText("Delete Student");

        studentCombo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Student)
                    setText(((Student) value).getName());
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });

        studentLabel.setText("Student:");
        submitButton.setText("Submit");
        cancelButton.setText("Cancel");

        submitButton.setBackground(new java.awt.Color(204, 255, 204));
        cancelButton.setBackground(new java.awt.Color(255, 204, 204));

        submitButton.addActionListener(this::submitButtonActionPerformed);
        cancelButton.addActionListener(this::cancelButtonActionPerformed);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(cancelButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(submitButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(studentLabel))
                                        .addComponent(studentCombo, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(26, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(titleLabel)
                                .addGap(51, 51, 51)));

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(titleLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(studentLabel)
                                .addGap(3, 3, 3)
                                .addComponent(studentCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(submitButton)
                                        .addComponent(cancelButton))
                                .addContainerGap(26, Short.MAX_VALUE)));
        pack();
    }

    private void submitButtonActionPerformed(ActionEvent evt) {
        Student student = ((Student) Objects.requireNonNull(studentCombo.getSelectedItem()));
        sv.deleteStudent(student);
        this.dispose();
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        this.dispose();
    }
}
