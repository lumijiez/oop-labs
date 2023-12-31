package org.lumijiez.gui;
import org.lumijiez.base.Document;
import org.lumijiez.tracker.TrackerThread;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.util.*;

public class MainFrame extends JFrame {
    public static Path FOLDER_PATH;
    private final JScrollPane fileListScrollPane = new JScrollPane();
    private final JScrollPane fileInfoScrollPane = new JScrollPane();
    private final JLabel pathLabel = new JLabel();
    private final JScrollPane mainScrollPane = new JScrollPane();
    private final JTextPane mainTextPane = new JTextPane();
    private final JTextPane fileInfoTextPane = new JTextPane();
    private final JLabel snapshotLabel = new JLabel();
    private final JButton CommitButton = new JButton();
    private final JButton StatusButton = new JButton();
    private final JMenuBar mainMenubar = new JMenuBar();
    private final JMenu fileMenu = new JMenu();
    private final JMenuItem pickFolder = new JMenuItem();
    private final JMenu settingsMenu = new JMenu();
    private final JMenuItem settings = new JMenuItem();
    private final JList<Document> fileList = new JList<>();
    private final Map<Document, byte[]> fileContents = new HashMap<>();
    private TrackerThread tracker;

    public MainFrame() {
        initComponents();
    }

    private void initComponents() {

        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainTextPane.setContentType("text/html");
        fileInfoTextPane.setContentType("text/html");

        mainTextPane.setEditable(false);
        fileInfoTextPane.setEditable(false);

        JFileChooser folderChooser = new JFileChooser();
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (folderChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            FOLDER_PATH = Path.of(folderChooser.getSelectedFile().getAbsolutePath());
            tracker = new TrackerThread(mainTextPane, fileContents, fileList, fileInfoTextPane);
            tracker.start();
        }

        snapshotLabel.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18));
        pathLabel.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18));

        fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fileListScrollPane.setViewportView(fileList);
        mainScrollPane.setViewportView(mainTextPane);
        fileInfoScrollPane.setViewportView(fileInfoTextPane);

        CommitButton.addActionListener(this::CommitButtonActionPerformed);

        fileMenu.add(pickFolder);
        settingsMenu.add(settings);
        mainMenubar.add(fileMenu);
        mainMenubar.add(settingsMenu);

        StatusButton.setText("Status");
        pathLabel.setText("Currently tracking: " + FOLDER_PATH.toString());
        CommitButton.setText("Commit");
        snapshotLabel.setText("Last snapshot: " + new Date());
        fileMenu.setText("File");
        pickFolder.setText("Pick another folder");
        settingsMenu.setText("Edit");
        settings.setText("Settings");

        setJMenuBar(mainMenubar);

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
                                .addContainerGap()));
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
}
