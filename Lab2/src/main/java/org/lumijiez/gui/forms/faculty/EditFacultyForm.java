/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.lumijiez.gui.forms.faculty;

import org.lumijiez.base.Faculty;
import org.lumijiez.enums.StudyField;
import org.lumijiez.gui.StudentManagementGUI;
import org.lumijiez.gui.util.ComponentDecorator;
import org.lumijiez.managers.Supervisor;
import org.lumijiez.gui.util.ComboBoxRenderers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class EditFacultyForm extends JFrame {
    private final Supervisor sv;
    private final JTextArea mainTextLabel;
    private final JTextField abbreviationField = new JTextField();
    private final JLabel abbreviationLabel = new JLabel();
    private final JButton cancelButton = new JButton();
    private final JLabel facultyLabel = new JLabel();
    private final JTextField nameField = new JTextField();
    private final JLabel nameLabel = new JLabel();
    private final JLabel specialtyLabel = new JLabel();
    private final JButton submitButton = new JButton();
    private final JLabel titleLabel = new JLabel();
    private final JComboBox<Faculty> facultyCombo;
    private final JComboBox<StudyField> specialtyCombo;

    public EditFacultyForm(Supervisor sv, JTextArea mainTextLabel) {
        this.sv = sv;
        this.mainTextLabel = mainTextLabel;
        facultyCombo = new JComboBox<>(sv.getFm().getFaculties().toArray(new Faculty[0]));
        specialtyCombo = new JComboBox<>(StudyField.getAllEnums().toArray(new StudyField[0]));
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        titleLabel.setText("Edit a faculty");
        submitButton.setText("Submit");
        cancelButton.setText("Cancel");
        nameLabel.setText("New name:");
        nameField.setText("Name...");
        facultyLabel.setText("Faculty:");
        abbreviationLabel.setText("New abbreviation:");
        abbreviationField.setText("Abbreviation...");
        specialtyLabel.setText("New specialty:");

        ComponentDecorator.submitButton(submitButton);
        ComponentDecorator.cancelButton(cancelButton);

        cancelButton.addActionListener(this::cancelButtonActionPerformed);
        submitButton.addActionListener(this::submitButtonActionPerformed);
        specialtyCombo.addActionListener(this::specialtyComboActionPerformed);
        facultyCombo.addActionListener(this::facultyComboActionPerformed);

        specialtyCombo.setSelectedItem(((Faculty) Objects.requireNonNull(facultyCombo.getSelectedItem())).getField());

        ComboBoxRenderers.setFacultyRenderer(facultyCombo);

        specialtyCombo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof StudyField)
                    setText(((StudyField) value).getName());
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(120, 120, 120)
                                                .addComponent(titleLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(facultyLabel)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(specialtyLabel)
                                                                        .addComponent(facultyCombo, 0, 115, Short.MAX_VALUE)
                                                                        .addComponent(specialtyCombo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(abbreviationLabel)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(abbreviationField, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(cancelButton)
                                                                                        .addGap(18, 18, 18)
                                                                                        .addComponent(submitButton)))
                                                                        .addComponent(nameLabel))))))
                                .addContainerGap(24, Short.MAX_VALUE)));

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameLabel)
                                        .addComponent(facultyLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(facultyCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(abbreviationLabel)
                                        .addComponent(specialtyLabel))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(abbreviationField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(specialtyCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton)
                                        .addComponent(submitButton))
                                .addGap(14, 14, 14)));
        pack();
    }

    private void facultyComboActionPerformed(ActionEvent actionEvent) {
        specialtyCombo.setSelectedItem(((Faculty) Objects.requireNonNull(facultyCombo.getSelectedItem())).getField());
    }

    private void specialtyComboActionPerformed(ActionEvent actionEvent) {
        abbreviationField.setText(((StudyField) Objects.requireNonNull(specialtyCombo.getSelectedItem())).getAbbreviation());
    }

    private void submitButtonActionPerformed(ActionEvent evt) {
        ((Faculty) Objects.requireNonNull(facultyCombo.getSelectedItem())).setName(nameField.getText());
        ((Faculty) Objects.requireNonNull(facultyCombo.getSelectedItem())).setAbbreviation(abbreviationField.getText());
        ((Faculty) Objects.requireNonNull(facultyCombo.getSelectedItem())).setField(((StudyField) Objects.requireNonNull(specialtyCombo.getSelectedItem())));
        StudentManagementGUI.displayFaculties();
        this.dispose();
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        this.dispose();
    }

}
