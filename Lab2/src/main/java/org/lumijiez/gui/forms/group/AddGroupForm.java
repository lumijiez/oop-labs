package org.lumijiez.gui.forms.group;

import org.lumijiez.base.Faculty;
import org.lumijiez.base.Group;
import org.lumijiez.gui.util.ComboBoxRenderer;
import org.lumijiez.gui.util.ComponentDecorator;
import org.lumijiez.gui.util.DisplayerManager;
import org.lumijiez.managers.Supervisor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class AddGroupForm extends JFrame {

    private final Supervisor sv;
    private final JLabel titleLabel = new JLabel();
    private final JTextField nameField = new JTextField();
    private final JButton submitButton = new JButton();
    private final JButton cancelButton = new JButton();
    private final JLabel nameLabel = new JLabel();
    private final JComboBox<Faculty> facultyCombo = new JComboBox<>();
    private final JLabel facultyLabel = new JLabel();

    public AddGroupForm(Supervisor sv) {
        this.sv = sv;
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("sansserif", Font.PLAIN, 18));
        setTitle("Add a Group");

        titleLabel.setText("Add a new group");
        submitButton.setText("Submit");
        cancelButton.setText("Cancel");
        nameLabel.setText("Name:");
        facultyLabel.setText("Faculty:");

        ComponentDecorator.submitAndCancel(submitButton, cancelButton);

        submitButton.addActionListener(this::submitButtonActionPerformed);
        cancelButton.addActionListener(this::cancelButtonActionPerformed);

        ComboBoxRenderer.setRenderer(facultyCombo, sv.getFm().getFaculties().toArray(new Faculty[0]));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(nameField, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(5, 5, 5)
                                                                .addComponent(nameLabel))
                                                        .addComponent(facultyLabel)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(cancelButton)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(submitButton))
                                                        .addComponent(facultyCombo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(titleLabel)))
                                .addContainerGap(29, Short.MAX_VALUE)));

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel)
                                .addGap(13, 13, 13)
                                .addComponent(nameLabel)
                                .addGap(3, 3, 3)
                                .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(facultyLabel)
                                .addGap(5, 5, 5)
                                .addComponent(facultyCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton)
                                        .addComponent(submitButton))
                                .addGap(15, 15, 15)));
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);
    }

    private void submitButtonActionPerformed(ActionEvent evt) {
        if (!nameField.getText().isEmpty()) {
            Group gr = new Group(nameField.getText());
            Faculty fac = ((Faculty) Objects.requireNonNull(facultyCombo.getSelectedItem()));
            sv.addGroup(gr, fac);
            DisplayerManager.displayGroups();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Fill in all the fields!", "Warning!", JOptionPane.INFORMATION_MESSAGE, null);
        }
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        this.dispose();
    }

}
