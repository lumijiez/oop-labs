package org.lumijiez.gui;
import org.lumijiez.tracker.TrackerThread;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;

public class MainFrame extends JFrame {
    private final JScrollPane fileListScrollPane = new JScrollPane();
    private final JList<String> fileList = new JList<>();
    private final JLabel pathLabel = new JLabel();
    private final JScrollPane mainScrollPane = new JScrollPane();
    private final JTextPane mainTextPane = new JTextPane();
    private final JLabel snapshotLabel = new JLabel();
    private final JButton CommitButton = new JButton();
    private final JButton StatusButton = new JButton();
    private final JMenuBar MainMenubar = new JMenuBar();
    private final JMenu fileMenu = new JMenu();
    private final JMenuItem pickFolder = new JMenuItem();
    private final JMenu settingsMenu = new JMenu();
    private final JMenuItem settings = new JMenuItem();

    public MainFrame() {
        initComponents();
    }

    private void initComponents() {


        JFileChooser folderChooser = new JFileChooser();
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnVal = folderChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("Selected folder: " + folderChooser.getSelectedFile().getAbsolutePath());
            TrackerThread tr = new TrackerThread(mainTextPane, Path.of(folderChooser.getSelectedFile().getAbsolutePath()));
            tr.start();
        }

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        fileList.setModel(new AbstractListModel<>() {
            final String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fileListScrollPane.setViewportView(fileList);

        snapshotLabel.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        snapshotLabel.setText("Last snapshot:");

        mainScrollPane.setViewportView(mainTextPane);

        pathLabel.setFont(new java.awt.Font("Trebuchet MS", Font.PLAIN, 18)); // NOI18N
        pathLabel.setText("Currently tracking: ");

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
                                        .addComponent(pathLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(snapshotLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(fileListScrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(mainScrollPane, GroupLayout.PREFERRED_SIZE, 599, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(CommitButton)
                                                                .addGap(0, 1, Short.MAX_VALUE))
                                                        .addComponent(StatusButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(snapshotLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pathLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(fileListScrollPane, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                                                .addComponent(mainScrollPane))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(CommitButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(StatusButton)))
                                .addContainerGap())
        );

        pack();
    }

    private void CommitButtonActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void StatusButtonActionPerformed(java.awt.event.ActionEvent evt) {
    }
}
