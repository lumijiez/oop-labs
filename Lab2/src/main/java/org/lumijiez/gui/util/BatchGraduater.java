package org.lumijiez.gui.util;

import org.lumijiez.base.Faculty;
import org.lumijiez.base.Group;
import org.lumijiez.base.Student;
import org.lumijiez.enums.StudyField;
import org.lumijiez.managers.Supervisor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BatchGraduater extends JFrame {
    private final Supervisor sv;
    private JTextPane filePane;

    public BatchGraduater(Supervisor sv) {
        this.sv = sv;
        this.setTitle("Graduate a Batch of Students");
        initComponents();
    }

    private void initComponents() {

        JButton submitButton = new JButton();
        JLabel titleLabel = new JLabel();
        JButton browseButton = new JButton();
        JLabel formatLabel = new JLabel();
        JScrollPane exampleLabel = new JScrollPane();
        JTextArea exampleText = new JTextArea();
        JButton cancelButton = new JButton();
        filePane = new JTextPane();

        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));

        submitButton.addActionListener(this::submitButtonActionPerformed);
        cancelButton.addActionListener(this::cancelButtonActionPerformed);
        browseButton.addActionListener(this::browseButtonActionPerformed);

        ComponentDecorator.submitButton(submitButton);
        ComponentDecorator.cancelButton(cancelButton);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setText("Pick a file to graduate a batch");
        submitButton.setText("Submit");
        browseButton.setText("Browse");
        formatLabel.setText("File format example:");
        cancelButton.setText("Cancel");


        exampleText.setColumns(15);
        exampleText.setRows(5);
        exampleText.setEditable(false);
        exampleText.setText("name: John\nsurname: Doe\nemail: john.doe@example.com\ngroup: FAF-223\nfaculty: FCIM\nspecialty: Mechanical Engineering");
        exampleLabel.setViewportView(exampleText);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(filePane, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(browseButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(104, 104, 104)
                                                .addComponent(cancelButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(submitButton))
                                        .addComponent(formatLabel)
                                        .addComponent(exampleLabel, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(33, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(titleLabel)
                                .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(titleLabel)
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(filePane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(browseButton))
                                .addGap(18, 18, 18)
                                .addComponent(formatLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exampleLabel, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton)
                                        .addComponent(submitButton))
                                .addGap(23, 23, 23)));
        pack();
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    private void browseButtonActionPerformed(ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            java.io.File file = fileChooser.getSelectedFile();
            filePane.setText(file.getAbsolutePath());
        }
    }

    private void submitButtonActionPerformed(ActionEvent evt) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePane.getText()))) {
            String line;
            String name;
            String surname;
            String email;
            String groupName;
            String facultyName;
            StudyField specialty;

            while (true) {
                line = reader.readLine();
                // Sorry for this
                if (line == null) break;
                if (line.isEmpty()) line = reader.readLine();
                name = line.substring("name: ".length());

                line = reader.readLine();
                // Sorry for this
                if (line == null) break;
                surname = line.substring("surname: ".length());

                line = reader.readLine();
                // Sorry for this
                if (line == null) break;
                email = line.substring("email: ".length());

                line = reader.readLine();
                // Sorry for this again lol
                if (line == null) break;
                groupName = line.substring("group: ".length());

                line = reader.readLine();
                // Sorry for this again :((
                if (line == null) break;
                facultyName = line.substring("faculty: ".length());

                line = reader.readLine();
                // This is the last one please don't hate me
                if (line == null) break;
                String spec = line.substring("specialty: ".length());

                if (StudyField.getEnum(spec) == null) {
                    specialty = StudyField.DEFAULT_UNASSIGNED;
                } else specialty = StudyField.getEnum(spec);

                Faculty faculty;
                Group group;

                if (sv.getFacultyByName(facultyName) == null) {
                    assert specialty != null;
                    faculty = new Faculty(facultyName, specialty.getAbbreviation(), specialty);
                    sv.addFaculty(faculty);
                } else faculty = sv.getFacultyByName(facultyName);


                if (sv.getGroupByName(groupName, faculty) == null) {
                    group = new Group(groupName);
                    sv.addGroup(group, sv.getFacultyByName(facultyName));
                } else group = sv.getGroupByName(groupName, faculty);

                for (Student st : group.getStudents()) {
                    if (st.getName().equals(name) && st.getSurname().equals(surname) && st.getEmail().equals(email)) {
                        st.setGraduated(true);
                        sv.getLogger().logOperation("Graduated student: " + st.getFullname() + " " + st.getGroup().getName());
                    }
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        DisplayerManager.displayStudents();

        this.dispose();
    }
}
