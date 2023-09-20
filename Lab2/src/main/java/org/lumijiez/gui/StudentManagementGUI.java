package org.lumijiez.gui;

import org.lumijiez.data.DataDeserializer;
import org.lumijiez.data.DataSerializer;
import org.lumijiez.gui.forms.*;
import org.lumijiez.managers.Manager;

import javax.swing.*;
import java.awt.*;
public class StudentManagementGUI{
    private final Manager studentManager;
    private final JFrame frame;
    private final JTextArea outputTextArea;

    public StudentManagementGUI() {
        studentManager = DataDeserializer.deserialize();

        frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(800, 600);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(centerX, centerY);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setText("===== Students =====\n" + studentManager.getStudentsText());

        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(0, 1));

        JButton showStudentsBtn = new JButton("Show Students");
        JButton showGroupsBtn = new JButton("Show Groups");
        JButton changeStudentGroup = new JButton("Change group");
        JButton addStudentBtn = new JButton("Add Student");
        JButton addStudentGrade = new JButton("Add Grade");
        JButton deleteStudentBtn = new JButton("Delete Student");
        JButton showStudentGradesBtn = new JButton("Show Student Grades");
        JButton saveAndExitBtn = new JButton("Save and Exit");


        showStudentsBtn.addActionListener(e -> outputTextArea.setText("===== Students =====\n" + studentManager.getStudentsText()));

        showGroupsBtn.addActionListener(e -> outputTextArea.setText("===== Groups =====\n" + studentManager.getGroupsText()));

        addStudentBtn.addActionListener(e -> new AddStudentForm(centerX, centerY, studentManager, outputTextArea));

        changeStudentGroup.addActionListener(e -> new ChangeGroupForm(centerX, centerY, studentManager, outputTextArea));

        showStudentGradesBtn.addActionListener(e -> new ShowGradesForm(centerX, centerY, studentManager, outputTextArea));

        deleteStudentBtn.addActionListener(e -> new DeleteStudentForm(centerX, centerY, studentManager, outputTextArea));

        addStudentGrade.addActionListener(e -> new AddGradeForm(centerX, centerY, studentManager, outputTextArea));


        saveAndExitBtn.addActionListener(e -> {
            DataSerializer.serialize(studentManager);
            frame.dispose();
            System.exit(0);
        });

        buttonPanel.add(showStudentsBtn);
        buttonPanel.add(showGroupsBtn);
        buttonPanel.add(showStudentGradesBtn);
        buttonPanel.add(addStudentBtn);
        buttonPanel.add(addStudentGrade);
        buttonPanel.add(deleteStudentBtn);
        buttonPanel.add(saveAndExitBtn);

        mainPanel.add(buttonPanel, BorderLayout.WEST);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }
}
