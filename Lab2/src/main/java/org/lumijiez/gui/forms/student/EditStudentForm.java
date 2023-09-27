/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.lumijiez.gui.forms.student;

import org.lumijiez.base.Faculty;
import org.lumijiez.base.Group;
import org.lumijiez.base.Student;
import org.lumijiez.gui.StudentManagementGUI;
import org.lumijiez.gui.util.ComponentDecorator;
import org.lumijiez.managers.Supervisor;
import org.lumijiez.gui.util.ComboBoxRenderers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class EditStudentForm extends JFrame {
    Integer[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    Integer[] months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    Integer[] years = new Integer[100];
    private final Supervisor sv;
    private final JTextArea mainTextLabel;
    private final JButton cancelButton = new JButton();
    private final JTextField emailField = new JTextField();
    private final JLabel emailLabel = new JLabel();
    private final JComboBox<Faculty> facultyCombo;
    private final JLabel facultyLabel = new JLabel();
    private final JComboBox<Group> groupCombo;
    private final JLabel groupLabel = new JLabel();
    private final JTextField nameField = new JTextField();
    private final JComboBox<Integer> birthYearField;
    private final JComboBox<Integer> birthDayField;
    private final JComboBox<Integer> birthMonthField;
    private final JComboBox<Integer> enrolDayField;
    private final JComboBox<Integer> enrolMonthField;
    private final JComboBox<Integer> enrolYearField;
    private final JLabel nameLabel = new JLabel();
    private final JComboBox<Student> studentCombo;
    private final JLabel studentLabel = new JLabel();
    private final JButton submitButton = new JButton();
    private final JTextField surnameField = new JTextField();
    private final JLabel surnameLabel = new JLabel();
    private final JLabel titleLabel = new JLabel();
    private final JLabel birthYearLabel = new javax.swing.JLabel();
    private final JLabel birthDayLabel = new javax.swing.JLabel();
    private final JLabel birthMonthLabel = new javax.swing.JLabel();
    private final JLabel enrolDayLabel = new javax.swing.JLabel();
    private final JLabel enrolMonthLabel = new javax.swing.JLabel();
    private final JLabel enrolYearLabel = new javax.swing.JLabel();

    public EditStudentForm(Supervisor sv, JTextArea mainTextLabel) {
        this.sv = sv;
        this.mainTextLabel = mainTextLabel;
        birthDayField = new JComboBox<>(days);
        birthMonthField = new JComboBox<>(months);
        birthYearField = new JComboBox<>(years);
        enrolDayField = new JComboBox<>(days);
        enrolMonthField = new JComboBox<>(months);
        enrolYearField = new JComboBox<>(years);
        this.facultyCombo = new JComboBox<>(sv.getFm().getFaculties().toArray(new Faculty[0]));
        this.groupCombo = new JComboBox<>(sv.getFm().getGm().getGroups().toArray(new Group[0]));
        this.studentCombo = new JComboBox<>(sv.getFm().getGm().getSm().getStudents().toArray(new Student[0]));
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        titleLabel.setText("Edit a student");
        nameField.setText(((Student)studentCombo.getSelectedItem()).getName());
        submitButton.setText("Submit");
        cancelButton.setText("Cancel");
        studentLabel.setText("Student:");
        surnameField.setText(((Student)studentCombo.getSelectedItem()).getSurname());
        emailField.setText(((Student)studentCombo.getSelectedItem()).getEmail());
        nameLabel.setText("New name:");
        emailLabel.setText("New email:");
        groupLabel.setText("New group:");
        facultyLabel.setText("New faculty:");
        surnameLabel.setText("New surname:");
//        birthYearLabel.setText("Year of Birth:");
//
//        birthDayLabel.setText("Day of Birth:");
//
//        birthMonthLabel.setText("Month of Birth:");
//
//        enrolDayLabel.setText("Day of Enrollment:");
//
//        enrolMonthLabel.setText("Month of Enrollment:");
//
//        enrolYearLabel.setText("Year of Enrollment:");

        ComponentDecorator.submitButton(submitButton);
        ComponentDecorator.cancelButton(cancelButton);

        submitButton.addActionListener(this::submitButtonActionPerformed);
        cancelButton.addActionListener(this::cancelButtonActionPerformed);
        studentCombo.addActionListener(this::studentComboActionPerformed);

        ComboBoxRenderers.setFacultyRenderer(facultyCombo);;
        ComboBoxRenderers.setGroupRenderer(groupCombo);
        ComboBoxRenderers.setStudentRenderer(studentCombo);

        groupCombo.setSelectedItem(((Student)studentCombo.getSelectedItem()).getGroup());

        facultyCombo.setSelectedItem(((Student) studentCombo.getSelectedItem()).getFaculty());

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
                                                                                        .addComponent(birthYearLabel)
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
                                                                .addContainerGap()))))));
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
                                        .addComponent(birthYearLabel))
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
                                .addGap(21, 21, 21)));
        pack();
    }

    private void cancelButtonActionPerformed(ActionEvent actionEvent) {
        this.dispose();
    }

    private void studentComboActionPerformed(ActionEvent actionEvent) {
        surnameField.setText(((Student) Objects.requireNonNull(studentCombo.getSelectedItem())).getSurname());
        emailField.setText(((Student)studentCombo.getSelectedItem()).getEmail());
        nameField.setText(((Student)studentCombo.getSelectedItem()).getName());
        groupCombo.setSelectedItem(((Student)studentCombo.getSelectedItem()).getGroup());
        facultyCombo.setSelectedItem(((Student) studentCombo.getSelectedItem()).getFaculty());
    }

    private void submitButtonActionPerformed(ActionEvent evt) {
        String name = nameField.getText();
        String surname = surnameField.getText();
        String email = emailField.getText();
        Group group = (Group) Objects.requireNonNull(groupCombo.getSelectedItem());
        Faculty faculty = ((Faculty) Objects.requireNonNull(facultyCombo.getSelectedItem()));
        Student student = ((Student) Objects.requireNonNull(studentCombo.getSelectedItem()));
//        int birthYear = (Integer) Objects.requireNonNull(birthYearField.getSelectedItem());
//        int birthMonth = (Integer) Objects.requireNonNull(birthMonthField.getSelectedItem());
//        int birthDay = (Integer) Objects.requireNonNull(birthDayField.getSelectedItem());
//        int enrolYear = (Integer) Objects.requireNonNull(enrolYearField.getSelectedItem());
//        int enrolMonth = (Integer) Objects.requireNonNull(enrolMonthField.getSelectedItem());
//        int enrolDay = (Integer) Objects.requireNonNull(enrolDayField.getSelectedItem());
//
//        Calendar birthCalendar = Calendar.getInstance();
//        Calendar enrolCalendar = Calendar.getInstance();
//
//        birthCalendar.set(Calendar.YEAR, birthYear);
//        birthCalendar.set(Calendar.MONTH, birthMonth - 1);
//        birthCalendar.set(Calendar.DAY_OF_MONTH, birthDay);
//
//        enrolCalendar.set(Calendar.YEAR, enrolYear);
//        enrolCalendar.set(Calendar.MONTH, enrolMonth - 1);
//        enrolCalendar.set(Calendar.DAY_OF_MONTH, enrolDay);
//
//        Date birthDate = birthCalendar.getTime();
//        Date enrolDate = enrolCalendar.getTime();

        if (!name.isEmpty() && !surname.isEmpty() && !email.isEmpty()) {
            sv.editStudent(student, name, surname, email, group, faculty /*, birthDate, enrolDate*/);
        }

        StudentManagementGUI.displayStudents();
        this.dispose();
    }
}
