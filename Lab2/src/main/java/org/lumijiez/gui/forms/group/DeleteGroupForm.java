/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.lumijiez.gui.forms.group;

import org.lumijiez.managers.Supervisor;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DeleteGroupForm extends JFrame {
    private final Supervisor sv;
    private final JLabel mainTextLabel;
    private JButton cancelButton;
    private JComboBox<String> groupCombo;
    private JLabel groupLabel;
    private JButton submitButton;
    private JLabel titleLabel;
    public DeleteGroupForm(Supervisor sv, JLabel mainTextLabel) {
        this.sv = sv;
        this.mainTextLabel = mainTextLabel;
        initComponents();
    }

    private void initComponents() {

        titleLabel = new JLabel();
        groupCombo = new JComboBox<>();
        submitButton = new JButton();
        cancelButton = new JButton();
        groupLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        titleLabel.setText("Delete a group");

        groupCombo.setModel(new DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        submitButton.setBackground(new java.awt.Color(204, 255, 204));
        submitButton.setText("Submit");
        submitButton.addActionListener(this::submitButtonActionPerformed);

        cancelButton.setBackground(new java.awt.Color(255, 204, 204));
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(this::cancelButtonActionPerformed);

        groupLabel.setText("Group:");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(groupLabel)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(cancelButton)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(submitButton))
                                                                .addComponent(groupCombo, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addComponent(titleLabel)))
                                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(groupLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(groupCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton)
                                        .addComponent(submitButton))
                                .addContainerGap(18, Short.MAX_VALUE))
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
