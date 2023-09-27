/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.lumijiez.gui.forms.student;

import org.lumijiez.base.Grade;
import org.lumijiez.base.Student;
import org.lumijiez.enums.Subjects;
import org.lumijiez.managers.Supervisor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class GradeStudentForm extends JFrame {
    Integer[] grades = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private final Supervisor sv;
    private final JTextArea mainTextLabel;
    private final JButton cancelButton = new JButton();
    private final JComboBox<Subjects> subjectCombo;
    private final JLabel gradeLabel = new JLabel();
    private final JComboBox<Student> studentCombo;
    private final JComboBox<Integer> gradeCombo;
    private final JLabel studentLabel = new JLabel();
    private final JLabel subjectLabel = new JLabel();
    private final JButton submitButton = new JButton();
    private final JLabel titleLabel = new JLabel();

    public GradeStudentForm(Supervisor sv, JTextArea mainTextLabel) {
        this.sv = sv;
        this.mainTextLabel = mainTextLabel;
        this.subjectCombo = new JComboBox<>(Subjects.values());
        this.gradeCombo = new JComboBox<>(grades);
        this.studentCombo = new JComboBox<>(sv.getFm().getGm().getSm().getStudents().toArray(new Student[0]));
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("sansserif", 0, 18));

        titleLabel.setText("Grade a student");
        studentLabel.setText("Student:");
        subjectLabel.setText("Subject:");
        submitButton.setText("Submit");
        gradeLabel.setText("Grade:");
        cancelButton.setText("Cancel");

        submitButton.setBackground(new java.awt.Color(204, 255, 204));
        cancelButton.setBackground(new java.awt.Color(255, 204, 204));

        submitButton.addActionListener(this::submitButtonActionPerformed);
        cancelButton.addActionListener(this::cancelButtonActionPerformed);

        studentCombo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Student)
                    setText(((Student) value).getName());
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });

        subjectCombo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Subjects)
                    setText(((Subjects) value).getName());
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });

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
                                                        .addComponent(gradeCombo, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
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
                                        .addComponent(gradeCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cancelButton)
                                        .addComponent(submitButton))
                                .addContainerGap(30, Short.MAX_VALUE)));
        pack();
    }

    private void submitButtonActionPerformed(ActionEvent evt) {
        Student student = ((Student) Objects.requireNonNull(studentCombo.getSelectedItem()));
        Subjects subject = Subjects.getEnum(Objects.requireNonNull(subjectCombo.getSelectedItem()).toString());
        int intGrade = (Integer) Objects.requireNonNull(gradeCombo.getSelectedItem());
        Grade grade = new Grade(subject, intGrade);
        sv.addGrade(student, grade);

        StringBuilder builder = new StringBuilder();
        builder.append("====================================\n");
        builder.append("Grades for ").append(student.getFullname()).append(" from ").append(student.getGroup().getName()).append(":\n");
        for (Grade gr : student.getGrades()) {
            builder.append(gr.getSubject()).append(": ").append(gr.getGrade()).append("\n");
        }
        builder.append("====================================\n");
        mainTextLabel.setText(builder.toString());

        this.dispose();
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        this.dispose();
    }

}
