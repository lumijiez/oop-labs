package org.lumijiez.tracker;

import org.lumijiez.base.Document;
import org.lumijiez.gui.MainFrame;
import org.lumijiez.enums.DiffType;
import org.lumijiez.util.FileDiffer;
import org.lumijiez.enums.StateType;
import org.lumijiez.util.FileFactory;
import org.lumijiez.util.NotificationHandler;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TrackerThread extends Thread {
    private final JTextPane textPane;
    private final JTextPane fileInfoTextPane;
    private final JList<Document> fileList;
    private Map<Document, byte[]> fileContents;
    private final Map<File, StateType> fileStates = new HashMap<>();

    public TrackerThread(JTextPane textPane, Map<Document, byte[]> files, JList<Document> fileList, JTextPane fileInfoTextPane) {
        this.textPane = textPane;
        this.fileContents = files;
        this.fileList = fileList;
        this.fileInfoTextPane = fileInfoTextPane;
        init();
    }

    public void init() {
        System.out.println("Init called");
        fileContents = FileDiffer.crawlDirectory(MainFrame.FOLDER_PATH);
        DefaultListModel<Document> listModel = new DefaultListModel<>();

        for (File file : fileContents.keySet()) {
            Document doc = FileFactory.getDocument(file.toPath());
            listModel.addElement(doc);
        }

        fileList.setModel(listModel);
        fileList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Document) {
                    value = ((Document) value).getName();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });

        fileList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                refreshFileInfo();
            }
        });
    }

    public void reset() {
        fileStates.clear();
    }

    public void refreshFileInfo() {
        Document selectedDocument = fileList.getSelectedValue();
        if (selectedDocument != null) {
            fileInfoTextPane.setText(selectedDocument.getInfo());
        } else {
            fileInfoTextPane.setText("");
        }
    }

    public void checkDirectory() {
        Map<DiffType, ArrayList<Document>> result = FileDiffer.diff(fileContents, FileDiffer.crawlDirectory(MainFrame.FOLDER_PATH.toFile()));

        StringBuilder toShow = new StringBuilder();
        boolean somethingNew = false;

        for (DiffType type : result.keySet()) {
            for (File file : result.get(type)) {
                somethingNew = true;
                System.out.println("File changed " + file.getName() + " " + type.getState().getAction());
                fileStates.put(file, type.getState());
            }
        }

        if (somethingNew) {
            init();
            refreshFileInfo();
            for (File file : fileStates.keySet()) {
                if (fileStates.get(file) != StateType.NONE) {
                    if (fileStates.get(file) == StateType.NEW) {
                        toShow.append("<span color=\"green\">");
                    }
                    if (fileStates.get(file) == StateType.DELETED) {
                        toShow.append("<span color=\"red\">");
                    }
                    if (fileStates.get(file) == StateType.MODIFIED) {
                        toShow.append("<span color=\"orange\">");
                    }
                    toShow.append(file.getName()).append(" has been ").append(fileStates.get(file).getAction()).append("</span><br>");
                    NotificationHandler.showNotification(file.getName(), fileStates.get(file));
                }
            }
            textPane.setText(toShow.toString());
        }
    }

    @Override
    public void run() {
        while(this.isAlive()) {
            checkDirectory();
        }
    }
}
