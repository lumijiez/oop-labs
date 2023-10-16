package org.lumijiez.tracker;

import org.lumijiez.util.DiffType;
import org.lumijiez.util.FileDiffer;
import org.lumijiez.util.StateType;

import javax.swing.*;
import java.io.File;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TrackerThread extends Thread {
    private final JTextPane textPane;
    private final Path path;
    private Map<File, byte[]> fileContents;
    private final JList<String> fileList;
    private final Map<File, StateType> fileStates = new HashMap<>();

    public TrackerThread(JTextPane textPane, Path path, Map<File, byte[]> files, JList<String> fileList) {
        this.textPane = textPane;
        this.path = path;
        this.fileContents = files;
        this.fileList = fileList;
        init();
    }

    public void init() {
        System.out.println("Init called");
        fileContents = FileDiffer.crawlDirectory(path);

        ArrayList<String> fileNames = new ArrayList<>();

        for (File file : fileContents.keySet()) {
            fileNames.add(file.getName());
        }
        fileList.setModel(new AbstractListModel<>() {
            public int getSize() {
                return fileNames.size();
            }
            public String getElementAt(int i) {
                return fileNames.get(i);
            }
        });
    }

    public void reset() {
        fileStates.clear();
    }

    public void checkDirectory() {
        Map<DiffType, ArrayList<File>> result = FileDiffer.diff(fileContents, FileDiffer.crawlDirectory(path));

        StringBuilder toShow = new StringBuilder();

        boolean created = false, deleted = false, modified = false;
        if (!result.get(DiffType.CREATE).isEmpty()) {
            created = true;
            for (File file : result.get(DiffType.CREATE)) {
                fileStates.put(file, StateType.NEW);
            }
            System.out.println("Created");
        }

        if (!result.get(DiffType.DELETE).isEmpty()) {
            deleted = true;
            for (File file : result.get(DiffType.DELETE)) {
                fileStates.put(file, StateType.DELETED);
            }
            System.out.println("Deleted");
        }

        if (!result.get(DiffType.MODIFY).isEmpty()) {
            modified = true;
            for (File file : result.get(DiffType.MODIFY)) {
                fileStates.put(file, StateType.MODIFIED);
            }
            System.out.println("Modified");
        }

        if (created || deleted || modified) {
            init();
            for (File file : fileStates.keySet()) {
                if (fileStates.get(file) != StateType.NONE) {
                    toShow.append(file.getName()).append(" has been ").append(fileStates.get(file).getName()).append("<br>");
                }
            }
            textPane.setText(toShow.toString());
        }
    }

    @Override
    public void run() {
        while(this.isAlive()) {
            checkDirectory();
            //Thread.sleep(200);
        }
    }
}
