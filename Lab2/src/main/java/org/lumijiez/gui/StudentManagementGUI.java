/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.lumijiez.gui;

import org.lumijiez.base.Faculty;
import org.lumijiez.base.Group;
import org.lumijiez.base.Student;
import org.lumijiez.data.DataDeserializer;
import org.lumijiez.data.DataSerializer;
import org.lumijiez.gui.forms.faculty.AddFacultyForm;
import org.lumijiez.gui.forms.faculty.EditFacultyForm;
import org.lumijiez.gui.forms.faculty.RemoveFacultyForm;
import org.lumijiez.gui.forms.faculty.ShowFacultyForm;
import org.lumijiez.gui.forms.group.AddGroupForm;
import org.lumijiez.gui.forms.group.DeleteGroupForm;
import org.lumijiez.gui.forms.group.EditGroupForm;
import org.lumijiez.gui.forms.group.ShowGroupForm;
import org.lumijiez.gui.forms.student.*;
import org.lumijiez.managers.Supervisor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StudentManagementGUI extends JFrame {
    private Supervisor sv;
    private final JLabel mainTextLabel = new JLabel();
    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu fileMenu = new JMenu();
    private final JMenuItem loadBatchOption = new JMenuItem();
    private final JMenuItem saveAsOption = new JMenuItem();
    private final JMenuItem saveAndExitOption = new JMenuItem();
    private final JMenuItem settingsOption = new JMenuItem();
    private final JMenu studentMenu = new JMenu();
    private final JMenuItem showAllStudentsOption = new JMenuItem();
    private final JMenuItem showParticularStudentOption = new JMenuItem();
    private final JMenuItem showStudentGrade = new JMenuItem();
    private final JPopupMenu.Separator studentSeparator = new JPopupMenu.Separator();
    private final JMenuItem gradeStudentOption = new JMenuItem();
    private final JMenuItem addStudentOption = new JMenuItem();
    private final JMenuItem editStudentOption = new JMenuItem();
    private final JMenuItem deleteStudentOption = new JMenuItem();
    private final JMenu groupMenu = new JMenu();
    private final JMenuItem showAllGroupsOption = new JMenuItem();
    private final JMenuItem showParticularGroupOption = new JMenuItem();
    private final JPopupMenu.Separator groupSeparator = new JPopupMenu.Separator();
    private final JMenuItem addGroupOption = new JMenuItem();
    private final JMenuItem editGroupOption = new JMenuItem();
    private final JMenuItem deleteGroupOption = new JMenuItem();
    private final JMenu facultyMenu = new JMenu();
    private final JMenuItem showAllFacultiesOption = new JMenuItem();
    private final JMenuItem showParticularFacultyOption = new JMenuItem();
    private final JPopupMenu.Separator facultySeparator = new JPopupMenu.Separator();
    private final JMenuItem addFacultyOption = new JMenuItem();
    private final JMenuItem editFacultyOption = new JMenuItem();
    private final JMenuItem removeFacultyOption = new JMenuItem();

    public StudentManagementGUI() {
        this.sv = DataDeserializer.deserialize();
        initComponents();
    }
    private void initComponents() {

        fileMenu.setText("File");
        loadBatchOption.setText("Load Batch File");
        saveAsOption.setText("Save As File");
        saveAndExitOption.setText("Save And Exit");
        settingsOption.setText("Settings");
        studentMenu.setText("Student Options");
        showAllStudentsOption.setText("Show All Students");
        showParticularStudentOption.setText("Show Student");
        showStudentGrade.setText("Show Student Grades");
        gradeStudentOption.setText("Grade Student");
        addStudentOption.setText("Add Student");
        editStudentOption.setText("Edit Student");
        deleteStudentOption.setText("Delete Student");
        groupMenu.setText("Group Options");
        showAllGroupsOption.setText("Show All Groups");
        showParticularGroupOption.setText("Show Group");
        addGroupOption.setText("Add Group");
        editGroupOption.setText("Edit Group");
        deleteGroupOption.setText("Delete Group");
        facultyMenu.setText("Faculty Options");
        showAllFacultiesOption.setText("Show Faculties");
        showParticularFacultyOption.setText("Show A Faculty");
        addFacultyOption.setText("Add Faculty");
        removeFacultyOption.setText("Remove Faculty");
        editFacultyOption.setText("Edit Faculty");

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        StudentManagementGUI.this,
                        "Are you sure you want to exit?",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION
                );

                if (result == JOptionPane.YES_OPTION) {
                    DataSerializer.serialize(sv);
                    dispose();
                }
            }
        });


        loadBatchOption.addActionListener(this::loadBatchOptionActionPerformed);
        saveAsOption.addActionListener(this::saveAsOptionActionPerformed);
        saveAndExitOption.addActionListener(this::saveAndExitOptionActionPerformed);

        fileMenu.add(loadBatchOption);
        fileMenu.add(saveAsOption);
        fileMenu.add(saveAndExitOption);
        fileMenu.add(settingsOption);

        menuBar.add(fileMenu);

        showParticularStudentOption.addActionListener(this::showParticularStudentOptionActionPerformed);
        showStudentGrade.addActionListener(this::showStudentGradeActionPerformed);
        gradeStudentOption.addActionListener(this::gradeStudentOptionActionPerformed);
        addStudentOption.addActionListener(this::addStudentOptionActionPerformed);
        editStudentOption.addActionListener(this::editStudentOptionActionPerformed);
        deleteStudentOption.addActionListener(this::deleteStudentOptionActionPerformed);

        studentMenu.add(showAllStudentsOption);
        studentMenu.add(showParticularStudentOption);
        studentMenu.add(showStudentGrade);
        studentMenu.add(studentSeparator);
        studentMenu.add(gradeStudentOption);
        studentMenu.add(addStudentOption);
        studentMenu.add(editStudentOption);
        studentMenu.add(deleteStudentOption);

        menuBar.add(studentMenu);

        showParticularGroupOption.addActionListener(this::showParticularGroupOptionActionPerformed);
        addGroupOption.addActionListener(this::addGroupOptionActionPerformed);
        editGroupOption.addActionListener(this::editGroupOptionActionPerformed);

        groupMenu.add(showAllGroupsOption);
        groupMenu.add(showParticularGroupOption);
        groupMenu.add(groupSeparator);
        groupMenu.add(addGroupOption);
        groupMenu.add(editGroupOption);
        groupMenu.add(deleteGroupOption);

        menuBar.add(groupMenu);

        showAllGroupsOption.addActionListener(this::showAllGroupsOptionActionPerformed);
        showAllStudentsOption.addActionListener(this::showAllStudentsOptionActionPerformed);
        showAllFacultiesOption.addActionListener(this::showAllFacultiesOptionActionPerformed);
        showParticularFacultyOption.addActionListener(this::showParticularFacultyOptionActionPerformed);
        addFacultyOption.addActionListener(this::addFacultyOptionActionPerformed);
        editFacultyOption.addActionListener(this::editFacultyOptionActionPerformed);
        deleteGroupOption.addActionListener(this::deleteGroupOptionActionPerformed);
        removeFacultyOption.addActionListener(this::removeFacultyOptionActionPerformed);

        facultyMenu.add(showAllFacultiesOption);
        facultyMenu.add(showParticularFacultyOption);
        facultyMenu.add(facultySeparator);
        facultyMenu.add(addFacultyOption);
        facultyMenu.add(editFacultyOption);
        facultyMenu.add(removeFacultyOption);


        menuBar.add(facultyMenu);

        setJMenuBar(menuBar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(mainTextLabel, GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE));
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(mainTextLabel, GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE));
        pack();
    }

    private void showAllStudentsOptionActionPerformed(ActionEvent actionEvent) {
        if (checkStudent() && checkGroup() && checkFaculty()) {
            StringBuilder builder = new StringBuilder();
            for (Student st : sv.getFm().getGm().getSm().getStudents()) {
                builder.append(st.getFullname()).append("\n");
            }
            mainTextLabel.setText(builder.toString());
        }
    }

    private void showAllGroupsOptionActionPerformed(ActionEvent actionEvent) {
        if (checkGroup() && checkFaculty()) {
            StringBuilder builder = new StringBuilder();
            for (Group gr : sv.getFm().getGm().getGroups())
                builder.append(gr.getName()).append("\n");
            mainTextLabel.setText(builder.toString());
        }
    }

    private void deleteGroupOptionActionPerformed(ActionEvent actionEvent) {
        if (checkGroup() && checkFaculty()) {
            DeleteGroupForm form = new DeleteGroupForm(sv, mainTextLabel);
            form.setVisible(true);
        }
    }

    private void loadBatchOptionActionPerformed(ActionEvent evt) {

    }

    private void saveAndExitOptionActionPerformed(ActionEvent evt) {
        int result = JOptionPane.showConfirmDialog(
                StudentManagementGUI.this,
                "Are you sure you want to exit?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            DataSerializer.serialize(sv);
            dispose();
        }
    }

    private void showAllFacultiesOptionActionPerformed(ActionEvent evt) {
        if (checkFaculty()) {
            StringBuilder builder = new StringBuilder();
            for (Faculty fc : sv.getFm().getFaculties()) {
                builder.append(fc.getName()).append(" ").append(fc.getAbbreviation()).append(" ").append(fc.getField().getName());
            }
            mainTextLabel.setText(builder.toString());
        }
    }

    private void saveAsOptionActionPerformed(ActionEvent evt) {
     
    }

    private void showParticularGroupOptionActionPerformed(ActionEvent evt) {
        if (checkGroup() && checkFaculty()) {
            ShowGroupForm form = new ShowGroupForm(sv, mainTextLabel);
            form.setVisible(true);
        }
    }

    private void addFacultyOptionActionPerformed(ActionEvent evt) {
        AddFacultyForm form = new AddFacultyForm(sv, mainTextLabel);
        form.setVisible(true);
    }

    private void addStudentOptionActionPerformed(ActionEvent evt) {
        if (checkGroup() && checkFaculty()) {
            AddStudentForm form = new AddStudentForm(sv);
            form.setVisible(true);
        }
    }

    private void gradeStudentOptionActionPerformed(ActionEvent evt) {
        if (checkStudent() && checkGroup() && checkFaculty()) {
            GradeStudentForm form = new GradeStudentForm(sv, mainTextLabel);
            form.setVisible(true);
        }
    }

    private void editStudentOptionActionPerformed(ActionEvent evt) {
        if (checkStudent() && checkGroup() && checkFaculty()) {
            EditStudentForm form = new EditStudentForm(sv, mainTextLabel);
            form.setVisible(true);
        }
    }

    private void deleteStudentOptionActionPerformed(ActionEvent evt) {
        if (checkStudent() && checkGroup() && checkFaculty()) {
            DeleteStudentForm form = new DeleteStudentForm(sv, mainTextLabel);
            form.setVisible(true);
        }
    }

    private void showStudentGradeActionPerformed(ActionEvent evt) {
        if (checkStudent() && checkGroup() && checkFaculty()) {
            ShowStudentGradesForm form = new ShowStudentGradesForm(sv, mainTextLabel);
            form.setVisible(true);
        }
    }

    private void showParticularStudentOptionActionPerformed(ActionEvent evt) {
        if (checkStudent() && checkGroup() && checkFaculty()) {
            ShowStudentForm form = new ShowStudentForm(sv, mainTextLabel);
            form.setVisible(true);
        }
    }

    private void addGroupOptionActionPerformed(ActionEvent evt) {
        if (checkFaculty()) {
            AddGroupForm form = new AddGroupForm(sv, mainTextLabel);
            form.setVisible(true);
        }
    }

    private void editGroupOptionActionPerformed(ActionEvent evt) {
        if (checkGroup() && checkFaculty()) {
            EditGroupForm form = new EditGroupForm(sv, mainTextLabel);
            form.setVisible(true);
        }
    }

    private void showParticularFacultyOptionActionPerformed(ActionEvent evt) {
        if (checkFaculty()) {
            ShowFacultyForm form = new ShowFacultyForm(sv, mainTextLabel);
            form.setVisible(true);
        }
    }

    private void editFacultyOptionActionPerformed(ActionEvent evt) {
        if (checkFaculty()) {
            EditFacultyForm form = new EditFacultyForm(sv, mainTextLabel);
            form.setVisible(true);
        }
    }

    private void removeFacultyOptionActionPerformed(ActionEvent evt) {
        if (checkFaculty()) {
            RemoveFacultyForm form = new RemoveFacultyForm(sv, mainTextLabel);
            form.setVisible(true);
        }
    }

    private boolean checkFaculty() {
        if (sv.getFm().getFaculties().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Configure a faculty!", "Warning!", JOptionPane.INFORMATION_MESSAGE, null);
            return false;
        }
        return true;
    }

    private boolean checkGroup() {
        if (sv.getFm().getGm().getGroups().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Configure a group!", "Warning!", JOptionPane.INFORMATION_MESSAGE, null);
            return false;
        }
        return true;
    }

    private boolean checkStudent() {
        if (sv.getFm().getGm().getSm().getStudents().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No students in database!", "Warning!", JOptionPane.INFORMATION_MESSAGE, null);
            return false;
        }
        return true;
    }
}
