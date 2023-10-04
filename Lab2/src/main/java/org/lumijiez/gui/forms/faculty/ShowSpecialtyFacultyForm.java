package org.lumijiez.gui.forms.faculty;

import org.lumijiez.base.Faculty;
import org.lumijiez.enums.StudyField;
import org.lumijiez.gui.util.ComboRenderer;
import org.lumijiez.gui.util.ComponentDecorator;
import org.lumijiez.gui.util.WindowConfig;
import org.lumijiez.managers.Supervisor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ShowSpecialtyFacultyForm extends JFrame {
    private final JLabel titleLabel = new JLabel();
    private final JLabel facultyLabel = new JLabel();
    private final JButton cancelButton = new JButton();
    private final JButton submitButton = new JButton();
    private final JComboBox<StudyField> specialtyCombo = new JComboBox<>();
    private final Supervisor sv;
    private final JTextArea mainTextLabel;

    public ShowSpecialtyFacultyForm(Supervisor sv, JTextArea mainTextLabel) {
        this.sv = sv;
        this.mainTextLabel = mainTextLabel;
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new Font("sansserif", Font.PLAIN, 18));
        setTitle("Show a Faculty by Specialty");

        titleLabel.setText("Show a faculty");
        submitButton.setText("Submit");
        cancelButton.setText("Cancel");
        facultyLabel.setText("Faculty:");

        ComponentDecorator.submitAndCancel(submitButton, cancelButton);

        submitButton.addActionListener(this::submitEvent);
        cancelButton.addActionListener(this::cancelEvent);

        ComboRenderer.setRenderer(specialtyCombo, StudyField.getAllEnums().toArray(new StudyField[0]));

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
                                                                .addComponent(specialtyCombo, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(27, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(titleLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(facultyLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(specialtyCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton)
                                        .addComponent(submitButton))
                                .addContainerGap(24, Short.MAX_VALUE)));
        pack();
        WindowConfig.center(this);
    }

    private void submitEvent(ActionEvent evt) {
        StringBuilder builder = new StringBuilder();
        StudyField fac = (StudyField) specialtyCombo.getSelectedItem();
        assert fac != null;
        builder.append("==================== Specialty Info =======================\n");
        builder.append("Specialty: ").append(fac.getName()).append("\n");
        builder.append("==========\n");
        builder.append("Faculties: ").append("\n");
        for (Faculty fc : sv.facultyManager().getFaculties())
            if (fc.getField().equals(fac))
                builder.append(fc.getName()).append("\n").append("==========\n");
        builder.append("============================================================");
        mainTextLabel.setText(builder.toString());
        this.dispose();
    }

    private void cancelEvent(ActionEvent evt) {
        this.dispose();
    }

}
