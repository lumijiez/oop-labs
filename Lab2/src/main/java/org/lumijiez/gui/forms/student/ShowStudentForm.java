package org.lumijiez.gui.forms.student;

import org.lumijiez.base.Student;
import org.lumijiez.gui.util.ComboRenderer;
import org.lumijiez.gui.util.ComponentDecorator;
import org.lumijiez.gui.util.WindowConfig;
import org.lumijiez.managers.Supervisor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class ShowStudentForm extends JFrame {
    private final JLabel studentLabel = new JLabel();
    private final JLabel titleLabel = new JLabel();
    private final JButton cancelButton = new JButton();
    private final JButton submitButton = new JButton();
    private final JComboBox<Student> studentCombo = new JComboBox<>();
    private final Supervisor sv;
    private final JTextArea mainTextLabel;

    public ShowStudentForm(Supervisor sv, JTextArea mainTextLabel) {
        this.sv = sv;
        this.mainTextLabel = mainTextLabel;
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new Font("sansserif", Font.PLAIN, 18));
        setTitle("Show A Student");

        titleLabel.setText("Show Student");
        submitButton.setText("Submit");
        studentLabel.setText("Student:");
        cancelButton.setText("Cancel");

        ComponentDecorator.submitAndCancel(submitButton, cancelButton);

        ComboRenderer.setRenderer(studentCombo, sv.studentManager().getStudents().toArray(new Student[0]));

        cancelButton.addActionListener(this::cancelEvent);
        submitButton.addActionListener(this::submitEvent);

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
                                                                .addComponent(studentCombo, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))))
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
        WindowConfig.center(this);
    }

    private void submitEvent(ActionEvent evt) {
        Student student = ((Student) Objects.requireNonNull(studentCombo.getSelectedItem()));
        StringBuilder text = new StringBuilder();

        text.append("====================== Student Info ======================\n");
        mainTextLabel.setText(text.toString());
        text.append("Name: ").append(student.getFullname()).append(" \n")
                .append("Group: ").append(student.getGroup().getName())
                .append(" \nFaculty: ").append(student.getFaculty().getName())
                .append(" \nEmail: ").append(student.getEmail()).append(" \n")
                .append("Bday: ").append(student.getDateOfBirth())
                .append("\nEnrol date: ").append(student.getEnrollmentDate())
                .append("\nGraduated: ").append(student.isGraduated());
        text.append("\n=======================================================");
        mainTextLabel.setText(text.toString());
        this.dispose();
    }

    private void cancelEvent(ActionEvent evt) {
        this.dispose();
    }

}
