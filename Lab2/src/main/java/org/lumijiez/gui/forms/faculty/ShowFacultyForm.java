/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.lumijiez.gui.forms.faculty;

import org.lumijiez.base.Faculty;
import org.lumijiez.base.Group;
import org.lumijiez.managers.Supervisor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ShowFacultyForm extends JFrame {

    private final Supervisor sv;
    private final JLabel mainTextLabel;
    private final JButton cancelButton = new JButton();
    private final JComboBox<Faculty> facultyCombo;
    private final JLabel facultyLabel = new JLabel();
    private final JButton submitButton = new JButton();
    private final JLabel titleLabel = new JLabel();

    public ShowFacultyForm(Supervisor sv, JLabel mainTextLabel) {
        this.sv = sv;
        this.mainTextLabel = mainTextLabel;
        this.facultyCombo = new JComboBox<>(sv.getFm().getFaculties().toArray(new Faculty[0]));
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        titleLabel.setText("Show a faculty");
        submitButton.setText("Submit");
        cancelButton.setText("Cancel");
        facultyLabel.setText("Faculty:");

        submitButton.setBackground(new java.awt.Color(204, 255, 204));
        cancelButton.setBackground(new java.awt.Color(255, 204, 204));

        submitButton.addActionListener(this::submitButtonActionPerformed);
        cancelButton.addActionListener(this::cancelButtonActionPerformed);
        facultyCombo.addActionListener(this::facultyComboActionPerformed);

        facultyCombo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Faculty)
                    setText(((Faculty) value).getName());
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
                                                .addGap(46, 46, 46)
                                                .addComponent(titleLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(facultyLabel)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(cancelButton)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(submitButton))
                                                                .addComponent(facultyCombo, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(27, Short.MAX_VALUE)));

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(titleLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(facultyLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(facultyCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton)
                                        .addComponent(submitButton))
                                .addContainerGap(24, Short.MAX_VALUE)));
        pack();
    }

    private void facultyComboActionPerformed(ActionEvent actionEvent) {
    }

    private void submitButtonActionPerformed(ActionEvent evt) {
        StringBuilder builder = new StringBuilder();
        Faculty fac = (Faculty) facultyCombo.getSelectedItem();
        assert fac != null;
        builder.append("Name: ").append(fac.getName()).append("\n");
        builder.append("Specialty: ").append(fac.getField()).append("\n");
        builder.append("Groups: ").append("\n");
        for (Group gr : fac.getGroups())
            builder.append(gr.getName()).append("\n");
        mainTextLabel.setText(builder.toString());
        this.dispose();
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        this.dispose();
    }

}
