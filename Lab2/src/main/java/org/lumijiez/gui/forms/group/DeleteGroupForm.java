/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.lumijiez.gui.forms.group;

import org.lumijiez.base.Faculty;
import org.lumijiez.base.Group;
import org.lumijiez.managers.Supervisor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DeleteGroupForm extends JFrame {
    private final Supervisor sv;
    private final JLabel mainTextLabel;
    private final JButton cancelButton = new JButton();
    private final JComboBox<Group> groupCombo;
    private final JLabel groupLabel = new JLabel();
    private final JButton submitButton = new JButton();
    private final JLabel titleLabel = new JLabel();

    public DeleteGroupForm(Supervisor sv, JLabel mainTextLabel) {
        this.sv = sv;
        this.mainTextLabel = mainTextLabel;
        this.groupCombo = new JComboBox<>(sv.getFm().getGm().getGroups().toArray(new Group[0]));
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        titleLabel.setText("Delete a group");
        submitButton.setText("Submit");
        cancelButton.setText("Cancel");
        groupLabel.setText("Group:");

        submitButton.setBackground(new java.awt.Color(204, 255, 204));
        cancelButton.setBackground(new java.awt.Color(255, 204, 204));

        submitButton.addActionListener(this::submitButtonActionPerformed);
        cancelButton.addActionListener(this::cancelButtonActionPerformed);

        groupCombo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Group)
                    setText(((Group) value).getName());
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });

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
                                .addContainerGap(29, Short.MAX_VALUE)));

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
                                .addContainerGap(18, Short.MAX_VALUE)));
        pack();
    }

    private void submitButtonActionPerformed(ActionEvent evt) {
        sv.deleteGroup(((Group)groupCombo.getSelectedItem()));
        this.dispose();
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        this.dispose();
    }
}
