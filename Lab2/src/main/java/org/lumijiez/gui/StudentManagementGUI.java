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
import org.lumijiez.gui.util.DisplayerManager;
import org.lumijiez.gui.util.FilePicker;
import org.lumijiez.managers.Supervisor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StudentManagementGUI extends JFrame {
    private static Supervisor sv;
    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu fileMenu = new JMenu();
    private final JMenu studentMenu = new JMenu();
    private final JMenu groupMenu = new JMenu();
    private final JMenu facultyMenu = new JMenu();
    private final JScrollPane mainScrollPane = new javax.swing.JScrollPane();
    private static final JTextArea mainTextLabel = new javax.swing.JTextArea();

    public StudentManagementGUI() {
        sv = DataDeserializer.deserialize();
        this.setSize(new Dimension(1280, 720));
        initComponents();
    }
    private void initComponents() {

        JMenuItem loadBatchOption = new JMenuItem("Load as Batch", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem saveAsOption = new JMenuItem("Save As", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem saveAndExitOption = new JMenuItem("Save and Exit", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem settingsOption = new JMenuItem("Settings", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem showAllStudentsOption = new JMenuItem("Show All Students", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem showParticularStudentOption = new JMenuItem("Show a Student", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem showStudentGrade = new JMenuItem("Show Student Grades", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem graduateStudent = new JMenuItem("Graduate Student", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem showGraduates = new JMenuItem("Show Graduates", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem showEnrolled = new JMenuItem("Show enrolled", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem gradeStudentOption = new JMenuItem("Grade a Student", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem addStudentOption = new JMenuItem("Add a Student", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem editStudentOption = new JMenuItem("Edit a Student", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem deleteStudentOption = new JMenuItem("Delete a Student", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem showAllGroupsOption = new JMenuItem("Show all Groups", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem showParticularGroupOption = new JMenuItem("Show a Group", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem addGroupOption = new JMenuItem("Add a Group", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem editGroupOption = new JMenuItem("Edit a Group", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem deleteGroupOption = new JMenuItem("Delete a Group", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem showAllFacultiesOption = new JMenuItem("Show all Faculties", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem showParticularFacultyOption = new JMenuItem("Show a Faculty", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem addFacultyOption = new JMenuItem("Add a Faculty", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem editFacultyOption = new JMenuItem("Edit a Faculty", UIManager.getIcon("FileView.directoryIcon"));
        JMenuItem removeFacultyOption = new JMenuItem("Remove Faculty", UIManager.getIcon("FileView.directoryIcon"));

        JPopupMenu.Separator studentSeparator = new JPopupMenu.Separator();
        JPopupMenu.Separator groupSeparator = new JPopupMenu.Separator();
        JPopupMenu.Separator facultySeparator = new JPopupMenu.Separator();

        fileMenu.setText("File");
        studentMenu.setText("Student Options");
        groupMenu.setText("Group Options");
        facultyMenu.setText("Faculty Options");

        mainTextLabel.setEditable(false);
        mainTextLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        mainScrollPane.setViewportView(mainTextLabel);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
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
        graduateStudent.addActionListener(this::graduateStudentOptionActionPerformed);
        showEnrolled.addActionListener(this::showEnrolledOptionActionPerformed);
        showGraduates.addActionListener(this::showGraduatesOptionActionPerformed);

        studentMenu.add(showAllStudentsOption);
        studentMenu.add(showParticularStudentOption);
        studentMenu.add(showStudentGrade);
        studentMenu.add(showEnrolled);
        studentMenu.add(showGraduates);
        studentMenu.add(studentSeparator);
        studentMenu.add(graduateStudent);
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

        DisplayerManager.displayStudents();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
        );
        pack();
    }

    private void showGraduatesOptionActionPerformed(ActionEvent actionEvent) {
        if (checkStudent() && checkGroup() && checkFaculty()) {
            DisplayerManager.displayGraduates();
        }
    }

    private void showEnrolledOptionActionPerformed(ActionEvent actionEvent) {
        if (checkStudent() && checkGroup() && checkFaculty()) {
            DisplayerManager.displayEnrolled();
        }
    }

    private void graduateStudentOptionActionPerformed(ActionEvent actionEvent) {
        if (checkStudent() && checkGroup() && checkFaculty()) {
            GraduateStudentForm form = new GraduateStudentForm(sv);
            form.setVisible(true);
        }
    }

    private void showAllStudentsOptionActionPerformed(ActionEvent actionEvent) {
        if (checkStudent() && checkGroup() && checkFaculty()) {
            DisplayerManager.displayStudents();
        }
    }

    private void showAllGroupsOptionActionPerformed(ActionEvent actionEvent) {
        if (checkGroup() && checkFaculty()) {
            DisplayerManager.displayGroups();
        }
    }

    private void deleteGroupOptionActionPerformed(ActionEvent actionEvent) {
        if (checkGroup() && checkFaculty()) {
            DeleteGroupForm form = new DeleteGroupForm(sv);
            form.setVisible(true);
        }
    }

    private void loadBatchOptionActionPerformed(ActionEvent evt) {
        FilePicker picker = new FilePicker(sv);
        picker.setVisible(true);
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
            DisplayerManager.displayFaculties();
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
        AddFacultyForm form = new AddFacultyForm(sv);
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
            EditStudentForm form = new EditStudentForm(sv);
            form.setVisible(true);
        }
    }

    private void deleteStudentOptionActionPerformed(ActionEvent evt) {
        if (checkStudent() && checkGroup() && checkFaculty()) {
            DeleteStudentForm form = new DeleteStudentForm(sv);
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
            AddGroupForm form = new AddGroupForm(sv);
            form.setVisible(true);
        }
    }

    private void editGroupOptionActionPerformed(ActionEvent evt) {
        if (checkGroup() && checkFaculty()) {
            EditGroupForm form = new EditGroupForm(sv);
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
            EditFacultyForm form = new EditFacultyForm(sv);
            form.setVisible(true);
        }
    }

    private void removeFacultyOptionActionPerformed(ActionEvent evt) {
        if (checkFaculty()) {
            RemoveFacultyForm form = new RemoveFacultyForm(sv);
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

    public static JTextArea getMainLabel() {
        return mainTextLabel;
    }

    public static Supervisor getSv() {
        return sv;
    }
}
