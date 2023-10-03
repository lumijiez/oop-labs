package org.lumijiez.gui.forms.group;

import org.lumijiez.base.Group;
import org.lumijiez.base.Student;
import org.lumijiez.gui.util.ComboBoxRenderer;
import org.lumijiez.gui.util.ComponentDecorator;
import org.lumijiez.managers.Supervisor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;


public class ShowGroupForm extends JFrame {

    private final JTextArea mainTextLabel;
    private final JButton cancelButton = new JButton();
    private final JComboBox<Group> groupCombo = new JComboBox<>();
    private final JLabel groupLabel = new JLabel();
    private final JButton submitButton = new JButton();
    private final JLabel titleLabel = new JLabel();
    private final Supervisor sv;

    public ShowGroupForm(Supervisor sv, JTextArea mainTextLabel) {
        this.sv = sv;
        this.mainTextLabel = mainTextLabel;
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("sansserif", Font.PLAIN, 18));
        setTitle("Show a Group");

        titleLabel.setText("Show a group");
        groupLabel.setText("Group:");
        cancelButton.setText("Cancel");
        submitButton.setText("Submit");

        ComponentDecorator.submitAndCancel(submitButton, cancelButton);

        submitButton.addActionListener(this::submitButtonActionPerformed);
        cancelButton.addActionListener(this::cancelButtonActionPerformed);

        ComboBoxRenderer.setRenderer(groupCombo, sv.getFm().getGm().getGroups().toArray(new Group[0]));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(groupLabel)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(cancelButton)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(submitButton))
                                                                .addComponent(groupCombo, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addComponent(titleLabel)))
                                .addContainerGap(24, Short.MAX_VALUE)));

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel)
                                .addGap(15, 15, 15)
                                .addComponent(groupLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(groupCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton)
                                        .addComponent(submitButton))
                                .addContainerGap(25, Short.MAX_VALUE)));
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);
    }

    private void submitButtonActionPerformed(ActionEvent evt) {
        StringBuilder text = new StringBuilder();
        Group gr = (Group) Objects.requireNonNull(groupCombo.getSelectedItem());

        text.append("======================= Group Info =========================\n");
        text.append("=================== Group: ").append(gr.getName()).append("=====================\n");

        for (Student student : gr.getStudents()) {
            text.append("Name: ").append(student.getName()).append("\nEmail: ").append(student.getEmail())
                    .append("\nEnrol date: ").append(student.getEnrollmentDate());
            text.append("\n===============================================\n");
        }
        mainTextLabel.setText(text.toString());
        this.dispose();
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        this.dispose();
    }
}
