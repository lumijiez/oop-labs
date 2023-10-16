package org.lumijiez.tracker;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.*;

public class TrackerThread extends Thread {
    private final JTextPane textPane;
    private final Path path;

    public TrackerThread(JTextPane textPane, Path path) {
        this.textPane = textPane;
        this.path = path;
    }

    public void checkDirectory(Path path) {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

            while (true) {
                WatchKey key;
                try {
                    key = watchService.take();
                } catch (InterruptedException e) {
                    return;
                }

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    @SuppressWarnings("unchecked")
                    WatchEvent<Path> ev = (WatchEvent<Path>) event;
                    Path fileName = ev.context();

                    System.out.println(kind.name() + ": " + fileName);

                    if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                        textPane.setText(textPane.getText() + " file created\n");
                    } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                        textPane.setText(textPane.getText() + " file modified\n");
                    } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                        textPane.setText(textPane.getText() + " file deleted\n");
                    }
                }

                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        checkDirectory(path);
    }
}
