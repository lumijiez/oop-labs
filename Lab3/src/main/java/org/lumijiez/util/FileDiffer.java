package org.lumijiez.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FileDiffer {
    public static Map<DiffType, ArrayList<File>> diff(Map<File, byte[]> oldFiles, Map<File, byte[]> newFiles) {
        Map<DiffType, ArrayList<File>> result = new HashMap<>();

        ArrayList<File> newFileList = new ArrayList<>();
        ArrayList<File> deletedFileList = new ArrayList<>();
        ArrayList<File> modifiedFileList = new ArrayList<>();

        for (File file : oldFiles.keySet()) {
            if (newFiles.get(file) != null) {
                if (Arrays.compare(oldFiles.get(file), newFiles.get(file)) != 0) {
                    modifiedFileList.add(file);
                }
            } else {
                deletedFileList.add(file);
            }
        }

        for (File file : newFiles.keySet()) {
            if (oldFiles.get(file) == null) {
                newFileList.add(file);
            }
        }

        result.put(DiffType.CREATE, newFileList);
        result.put(DiffType.DELETE, deletedFileList);
        result.put(DiffType.MODIFY, modifiedFileList);

        return result;
    }

    public static Map<File, byte[]> crawlDirectory(Path path) {
        Map<File, byte[]> newFileContents = new HashMap<>();
        try (Stream<Path> paths = Files.walk(path)) {
            paths.forEach(p -> {
                if (Files.isRegularFile(p)) {
                    try {
                        newFileContents.put(p.toFile(), Files.readAllBytes(p));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFileContents;
    }
}
