package org.lumijiez.util;

import org.lumijiez.base.Document;
import org.lumijiez.enums.DiffType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FileDiffer {
    public static Map<DiffType, ArrayList<Document>> diff(Map<Document, byte[]> oldFiles, Map<Document, byte[]> newFiles) {
        Map<DiffType, ArrayList<Document>> result = Map.of(
                        DiffType.CREATE, new ArrayList<>(),
                        DiffType.DELETE, new ArrayList<>(),
                        DiffType.MODIFY, new ArrayList<>());

        for (Document file : oldFiles.keySet()) {
            if (newFiles.get(file) != null) {
                if (Arrays.compare(oldFiles.get(file), newFiles.get(file)) != 0) {
                    result.get(DiffType.MODIFY).add(file);
                }
            } else {
                result.get(DiffType.DELETE).add(file);
            }
        }

        for (Document file : newFiles.keySet()) {
            if (oldFiles.get(file) == null) {
                result.get(DiffType.CREATE).add(file);
            }
        }

        return result;
    }

    public static Map<Document, byte[]> crawlDirectory(Path path) {
        Map<Document, byte[]> newFileContents = new HashMap<>();
        try (Stream<Path> paths = Files.walk(path)) {
            paths.forEach(p -> {
                Document doc = new Document(p);
                if (Files.isRegularFile(doc.toPath())) {
                    try {
                        newFileContents.put(doc, Files.readAllBytes(doc.toPath()));
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
