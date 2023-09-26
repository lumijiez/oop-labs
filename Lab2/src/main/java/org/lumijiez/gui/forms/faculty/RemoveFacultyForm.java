/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.lumijiez.gui.forms.faculty;

import org.lumijiez.managers.Supervisor;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RemoveFacultyForm extends JFrame {

    private final Supervisor sv;
    private final JLabel mainTextLabel;
    private JButton cancelButton;
    private JComboBox<String> facultyCombo;
    private JLabel facultyLabel;
    private JButton submitButton;
    private JLabel titleLabel;
    public RemoveFacultyForm(Supervisor sv, JLabel mainTextLabel) {
        this.sv = sv;
        this.mainTextLabel = mainTextLabel;
        initComponents();
    }

    private void initComponents() {

        titleLabel = new JLabel();
        submitButton = new JButton();
        cancelButton = new JButton();
        facultyCombo = new JComboBox<>();
        facultyLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        titleLabel.setText("Remove a faculty");

        submitButton.setBackground(new java.awt.Color(204, 255, 204));
        submitButton.setText("Submit");
        submitButton.addActionListener(this::submitButtonActionPerformed);

        cancelButton.setBackground(new java.awt.Color(255, 204, 204));
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(this::cancelButtonActionPerformed);

        facultyCombo.setModel(new DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        facultyLabel.setText("Faculty:");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(cancelButton)
                                                .addGap(38, 38, 38)
                                                .addComponent(submitButton))
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(facultyLabel)
                                                .addComponent(facultyCombo, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(32, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(titleLabel)
                                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel)
                                .addGap(18, 18, 18)
                                .addComponent(facultyLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(facultyCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton)
                                        .addComponent(submitButton))
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }

    private void submitButtonActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        this.dispose();
    }

}
