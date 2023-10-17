package org.lumijiez.tracker;

import org.lumijiez.gui.MainFrame;
import org.lumijiez.enums.DiffType;
import org.lumijiez.util.FileDiffer;
import org.lumijiez.enums.StateType;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TrackerThread extends Thread {
    private final JTextPane textPane;
    private Map<File, byte[]> fileContents;
    private final Map<File, StateType> fileStates = new HashMap<>();
    private final JList<String> fileList;

    public TrackerThread(JTextPane textPane, Map<File, byte[]> files, JList<String> fileList) {
        this.textPane = textPane;
        this.fileContents = files;
        this.fileList = fileList;
        init();
    }

    public void init() {
        System.out.println("Init called");
        fileContents = FileDiffer.crawlDirectory(MainFrame.FOLDER_PATH);
        ArrayList<File> fList = new ArrayList<>(fileContents.keySet());
        fileList.setModel(new AbstractListModel<>() {
            public int getSize() {
                return fList.size();
            }
            public String getElementAt(int i) {
                return fList.get(i).getName();
            }
        });
    }

    public void reset() {
        fileStates.clear();
    }

    public void checkDirectory() {
        Map<DiffType, ArrayList<File>> result = FileDiffer.diff(fileContents, FileDiffer.crawlDirectory(MainFrame.FOLDER_PATH));

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
                }
            }
            // System.out.println(toShow.toString());
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
