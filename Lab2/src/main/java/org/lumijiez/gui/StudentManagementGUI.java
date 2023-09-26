/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.lumijiez.gui;

import org.lumijiez.base.Faculty;
import org.lumijiez.data.DataDeserializer;
import org.lumijiez.data.DataSerializer;
import org.lumijiez.gui.forms.faculty.AddFacultyForm;
import org.lumijiez.gui.forms.faculty.EditFacultyForm;
import org.lumijiez.gui.forms.faculty.RemoveFacultyForm;
import org.lumijiez.gui.forms.faculty.ShowFacultyForm;
import org.lumijiez.gui.forms.group.AddGroupForm;
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
    JLabel mainTextLabel = new JLabel();
    public StudentManagementGUI() {
        this.sv = sv;
        initComponents();
        this.sv = DataDeserializer.deserialize();
    }
    private void initComponents() {


        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu();
        JMenuItem loadBatchOption = new JMenuItem();
        JMenuItem saveAsOption = new JMenuItem();
        JMenuItem saveAndExitOption = new JMenuItem();
        JMenuItem settingsOption = new JMenuItem();
        JMenu studentMenu = new JMenu();
        JMenuItem showAllStudentsOption = new JMenuItem();
        JMenuItem showParticularStudentOption = new JMenuItem();
        JMenuItem showStudentGrade = new JMenuItem();
        JPopupMenu.Separator studentSeparator = new JPopupMenu.Separator();
        JMenuItem gradeStudentOption = new JMenuItem();
        JMenuItem addStudentOption = new JMenuItem();
        JMenuItem editStudentOption = new JMenuItem();
        JMenuItem deleteStudentOption = new JMenuItem();
        JMenu groupMenu = new JMenu();
        JMenuItem showAllGroupsOption = new JMenuItem();
        JMenuItem showParticularGroupOption = new JMenuItem();
        JPopupMenu.Separator groupSeparator = new JPopupMenu.Separator();
        JMenuItem addGroupOption = new JMenuItem();
        JMenuItem editGroupOption = new JMenuItem();
        JMenuItem deleteGroupOption = new JMenuItem();
        JMenu facultyMenu = new JMenu();
        JMenuItem showAllFacultiesOption = new JMenuItem();
        JMenuItem showParticularFacultyOption = new JMenuItem();
        JPopupMenu.Separator facultySeparator = new JPopupMenu.Separator();
        JMenuItem addFacultyOption = new JMenuItem();
        JMenuItem editFacultyOption = new JMenuItem();
        JMenuItem removeFacultyOption = new JMenuItem();

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

        fileMenu.setText("File");

        loadBatchOption.setText("Load Batch File");
        loadBatchOption.addActionListener(this::loadBatchOptionActionPerformed);
        fileMenu.add(loadBatchOption);

        saveAsOption.setText("Save As File");
        saveAsOption.addActionListener(this::saveAsOptionActionPerformed);
        fileMenu.add(saveAsOption);

        saveAndExitOption.setText("Save And Exit");
        saveAndExitOption.addActionListener(this::saveAndExitOptionActionPerformed);
        fileMenu.add(saveAndExitOption);

        settingsOption.setText("Settings");
        fileMenu.add(settingsOption);

        menuBar.add(fileMenu);

        studentMenu.setText("Student Options");

        showAllStudentsOption.setText("Show All Students");
        studentMenu.add(showAllStudentsOption);

        showParticularStudentOption.setText("Show Student");
        showParticularStudentOption.addActionListener(this::showParticularStudentOptionActionPerformed);
        studentMenu.add(showParticularStudentOption);

        showStudentGrade.setText("Show Student Grades");
        showStudentGrade.addActionListener(this::showStudentGradeActionPerformed);
        studentMenu.add(showStudentGrade);
        studentMenu.add(studentSeparator);

        gradeStudentOption.setText("Grade Student");
        gradeStudentOption.addActionListener(this::gradeStudentOptionActionPerformed);
        studentMenu.add(gradeStudentOption);

        addStudentOption.setText("Add Student");
        addStudentOption.addActionListener(this::addStudentOptionActionPerformed);
        studentMenu.add(addStudentOption);

        editStudentOption.setText("Edit Student");
        editStudentOption.addActionListener(this::editStudentOptionActionPerformed);
        studentMenu.add(editStudentOption);

        deleteStudentOption.setText("Delete Student");
        deleteStudentOption.addActionListener(this::deleteStudentOptionActionPerformed);
        studentMenu.add(deleteStudentOption);

        menuBar.add(studentMenu);

        groupMenu.setText("Group Options");

        showAllGroupsOption.setText("Show All Groups");
        groupMenu.add(showAllGroupsOption);

        showParticularGroupOption.setText("Show Group");
        showParticularGroupOption.addActionListener(this::showParticularGroupOptionActionPerformed);
        groupMenu.add(showParticularGroupOption);
        groupMenu.add(groupSeparator);

        addGroupOption.setText("Add Group");
        addGroupOption.addActionListener(this::addGroupOptionActionPerformed);
        groupMenu.add(addGroupOption);

        editGroupOption.setText("Edit Group");
        editGroupOption.addActionListener(this::editGroupOptionActionPerformed);
        groupMenu.add(editGroupOption);

        deleteGroupOption.setText("Delete Group");
        groupMenu.add(deleteGroupOption);

        menuBar.add(groupMenu);

        facultyMenu.setText("Faculty Options");

        showAllFacultiesOption.setText("Show Faculties");
        showAllFacultiesOption.addActionListener(this::showAllFacultiesOptionActionPerformed);
        facultyMenu.add(showAllFacultiesOption);

        showParticularFacultyOption.setText("Show A Faculty");
        showParticularFacultyOption.addActionListener(this::showParticularFacultyOptionActionPerformed);
        facultyMenu.add(showParticularFacultyOption);
        facultyMenu.add(facultySeparator);

        addFacultyOption.setText("Add Faculty");
        addFacultyOption.addActionListener(this::addFacultyOptionActionPerformed);
        facultyMenu.add(addFacultyOption);

        editFacultyOption.setText("Edit Faculty");
        editFacultyOption.addActionListener(this::editFacultyOptionActionPerformed);
        facultyMenu.add(editFacultyOption);

        removeFacultyOption.setText("Remove Faculty");
        removeFacultyOption.addActionListener(this::removeFacultyOptionActionPerformed);
        facultyMenu.add(removeFacultyOption);

        menuBar.add(facultyMenu);

        setJMenuBar(menuBar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(mainTextLabel, GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(mainTextLabel, GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
        );

        pack();
    }

    private void loadBatchOptionActionPerformed(ActionEvent evt) {

    }

    private void saveAndExitOptionActionPerformed(ActionEvent evt) {
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

    private void showAllFacultiesOptionActionPerformed(ActionEvent evt) {
        StringBuilder builder = new StringBuilder();
        for (Faculty fc : sv.getFm().getFaculties()) {
            builder.append(fc.getName()).append(" ").append(fc.getAbbreviation()).append(" ").append(fc.getField().getName());
        }
        mainTextLabel.setText(builder.toString());
    }

    private void saveAsOptionActionPerformed(ActionEvent evt) {
     
    }

    private void showParticularGroupOptionActionPerformed(ActionEvent evt) {
        ShowGroupForm form = new ShowGroupForm(sv, mainTextLabel);
        form.setVisible(true);
    }

    private void addFacultyOptionActionPerformed(ActionEvent evt) {
        AddFacultyForm form = new AddFacultyForm(sv, mainTextLabel);
        form.setVisible(true);
    }

    private void addStudentOptionActionPerformed(ActionEvent evt) {
        AddStudentForm form = new AddStudentForm(sv, mainTextLabel);
        form.setVisible(true);
    }

    private void gradeStudentOptionActionPerformed(ActionEvent evt) {
        GradeStudentForm form = new GradeStudentForm(sv, mainTextLabel);
        form.setVisible(true);
    }

    private void editStudentOptionActionPerformed(ActionEvent evt) {
        EditStudentForm form = new EditStudentForm(sv, mainTextLabel);
        form.setVisible(true);
    }

    private void deleteStudentOptionActionPerformed(ActionEvent evt) {
        DeleteStudentForm form = new DeleteStudentForm(sv, mainTextLabel);
        form.setVisible(true);
    }

    private void showStudentGradeActionPerformed(ActionEvent evt) {
        ShowStudentGradesForm form = new ShowStudentGradesForm(sv, mainTextLabel);
        form.setVisible(true);
    }

    private void showParticularStudentOptionActionPerformed(ActionEvent evt) {
        ShowStudentForm form = new ShowStudentForm(sv, mainTextLabel);
        form.setVisible(true);
    }

    private void addGroupOptionActionPerformed(ActionEvent evt) {
        AddGroupForm form = new AddGroupForm(sv, mainTextLabel);
        form.setVisible(true);
    }

    private void editGroupOptionActionPerformed(ActionEvent evt) {
        EditGroupForm form = new EditGroupForm(sv, mainTextLabel);
        form.setVisible(true);
    }

    private void showParticularFacultyOptionActionPerformed(ActionEvent evt) {
        ShowFacultyForm form = new ShowFacultyForm(sv, mainTextLabel);
        form.setVisible(true);
    }

    private void editFacultyOptionActionPerformed(ActionEvent evt) {
        EditFacultyForm form = new EditFacultyForm(sv, mainTextLabel);
        form.setVisible(true);
    }

    private void removeFacultyOptionActionPerformed(ActionEvent evt) {
        RemoveFacultyForm form = new RemoveFacultyForm(sv, mainTextLabel);
        form.setVisible(true);
    }
}
