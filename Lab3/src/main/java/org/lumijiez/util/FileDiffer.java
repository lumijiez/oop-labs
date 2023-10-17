package org.lumijiez.util;

import org.lumijiez.enums.DiffType;

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
        Map<DiffType, ArrayList<File>> result = Map.of(
                        DiffType.CREATE, new ArrayList<>(),
                        DiffType.DELETE, new ArrayList<>(),
                        DiffType.MODIFY, new ArrayList<>());

        for (File file : oldFiles.keySet()) {
            if (newFiles.get(file) != null) {
                if (Arrays.compare(oldFiles.get(file), newFiles.get(file)) != 0) {
                    result.get(DiffType.MODIFY).add(file);
                }
            } else {
                result.get(DiffType.DELETE).add(file);
            }
        }

        for (File file : newFiles.keySet()) {
            if (oldFiles.get(file) == null) {
                result.get(DiffType.CREATE).add(file);
            }
        }

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
