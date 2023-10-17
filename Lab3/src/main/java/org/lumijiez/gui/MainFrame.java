package org.lumijiez.gui;
import org.lumijiez.tracker.TrackerThread;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.util.*;

public class MainFrame extends JFrame {
    public static Path FOLDER_PATH;
    private final JScrollPane fileListScrollPane = new JScrollPane();
    private final JScrollPane fileInfoScrollPane = new JScrollPane();
    private final JList<String> fileList = new JList<>();
    private final JLabel pathLabel = new JLabel();
    private final JScrollPane mainScrollPane = new JScrollPane();
    private final JTextPane mainTextPane = new JTextPane();
    private final JTextPane fileInfoTextPane = new JTextPane();
    private final JLabel snapshotLabel = new JLabel();
    private final JButton CommitButton = new JButton();
    private final JButton StatusButton = new JButton();
    private final JMenuBar MainMenubar = new JMenuBar();
    private final JMenu fileMenu = new JMenu();
    private final JMenuItem pickFolder = new JMenuItem();
    private final JMenu settingsMenu = new JMenu();
    private final JMenuItem settings = new JMenuItem();
    private final Map<File, byte[]> fileContents = new HashMap<>();
    private TrackerThread tracker;

    public MainFrame() {
        initComponents();
    }

    private void initComponents() {

        mainTextPane.setContentType("text/html");

        JFileChooser folderChooser = new JFileChooser();
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        int returnVal = folderChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            FOLDER_PATH = Path.of(folderChooser.getSelectedFile().getAbsolutePath());
            tracker = new TrackerThread(mainTextPane, fileContents, fileList);
            tracker.start();
        }

        fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fileListScrollPane.setViewportView(fileList);

        snapshotLabel.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18));
        snapshotLabel.setText("Last snapshot: " + new Date());

        mainScrollPane.setViewportView(mainTextPane);
        fileInfoScrollPane.setViewportView(fileInfoTextPane);

        pathLabel.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18));
        pathLabel.setText("Currently tracking: " + FOLDER_PATH.toString());

        CommitButton.setText("Commit");
        CommitButton.addActionListener(this::CommitButtonActionPerformed);

        StatusButton.setText("Status");
        StatusButton.addActionListener(this::StatusButtonActionPerformed);

        fileMenu.setText("File");

        pickFolder.setText("Pick another folder");
        fileMenu.add(pickFolder);

        MainMenubar.add(fileMenu);

        settingsMenu.setText("Edit");

        settings.setText("Settings");
        settingsMenu.add(settings);

        MainMenubar.add(settingsMenu);

        setJMenuBar(MainMenubar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(snapshotLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pathLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(fileListScrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(mainScrollPane, GroupLayout.PREFERRED_SIZE, 599, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(CommitButton, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                                        .addComponent(fileInfoScrollPane))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(snapshotLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pathLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(fileListScrollPane, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                                        .addComponent(mainScrollPane)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(CommitButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fileInfoScrollPane)))
                                .addContainerGap()));
        pack();
    }

    private void CommitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        tracker.reset();
        mainTextPane.setText("");
        snapshotLabel.setText("Last snapshot: " + new Date());
    }

    private void StatusButtonActionPerformed(java.awt.event.ActionEvent evt) {
    }
}
